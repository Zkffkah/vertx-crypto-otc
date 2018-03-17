package com.lowwor.vco.crawler


import com.lowwor.vco.crawler.api.CryptoOtcApi
import com.lowwor.vco.crawler.api.CryptoOtcService
import com.lowwor.vco.data.dao.RedisDAO
import com.lowwor.vco.service.MainVerticle.Companion.logger
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class OtcPriceCrawler(val redisDAO: RedisDAO) {
    private val compositeDisposable = CompositeDisposable()
    private val CRAWL_INTERVAL = 60L

    private var cryptoOtcApi: CryptoOtcApi
    private var okhttpClient: OkHttpClient
    private var cryptoOtcService: CryptoOtcService

    private var retrofit: Retrofit

    init {


        okhttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor {
                    logger.info(it)
                }.setLevel(HttpLoggingInterceptor.Level.BODY))
                .proxySelector(DynamicProxySelector())
                .build()

        retrofit = Retrofit.Builder()
                .baseUrl("https://lowwor.com/")//useless
                .client(okhttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()


        cryptoOtcService = retrofit.create(CryptoOtcService::class.java)
        cryptoOtcApi = CryptoOtcApi(cryptoOtcService)
    }

    fun startCrawl() {
        logger.info("start crawl")
        compositeDisposable += Flowable.interval(CRAWL_INTERVAL, TimeUnit.SECONDS)
                .onBackpressureBuffer()
                .subscribe {
                    crawlBtcPrices()
                    crawlUsdtPrices()
                }

    }


    private fun crawlBtcPrices() {
        logger.info("crawlBtcPrices")
        cryptoOtcApi.getBtcPrices().flatMapCompletable {
            redisDAO.saveOtcBtcPrices(it)
        }.subscribe({
            logger.info("save success")
        }, {
            logger.info(it.printStackTrace())
        })
    }

    private fun crawlUsdtPrices() {
        cryptoOtcApi.getUsdtPrices().flatMapCompletable {
            redisDAO.saveOtcUsdtPrices(it)
        }.subscribe({
            logger.info("save success")
        }, {
            logger.info(it.printStackTrace())
        })
    }

    fun stop() {
        compositeDisposable.clear()
    }
}