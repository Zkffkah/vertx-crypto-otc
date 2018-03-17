package com.lowwor.vco.data.dao

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lowwor.vco.crawler.model.price.DefaultPriceItem
import com.lowwor.vco.crawler.model.price.OtcPriceItem
import com.lowwor.vco.service.MainVerticle.Companion.logger
import io.reactivex.Completable
import io.reactivex.Single
import io.vertx.reactivex.redis.RedisClient

class RedisDAO(private val redis: RedisClient) {

    private val OTC_BTC_PRICES_KEY = "OTC_BTC_PRICES_KEY"
    private val OTC_USDT_PRICES_KEY = "OTC_USDT_PRICES_KEY"

    private val gson = Gson()

    fun saveOtcBtcPrices(priceItemList: List<OtcPriceItem>): Completable {
        return redis.rxSet(OTC_BTC_PRICES_KEY, gson.toJson(priceItemList))
    }

    fun getOtcBtcPrices(): Single<List<OtcPriceItem>> {
        logger.info("getOtcBtcPrices")
        return redis.rxGet(OTC_BTC_PRICES_KEY).map {
            gson.fromJson<List<DefaultPriceItem>>(it, object : TypeToken<List<DefaultPriceItem>>() {}.type)
        }
    }

    fun saveOtcUsdtPrices(priceItemList: List<OtcPriceItem>): Completable {
        return redis.rxSet(OTC_USDT_PRICES_KEY, gson.toJson(priceItemList))
    }

    fun getOtcUsdtPrices(): Single<List<OtcPriceItem>> {
        return redis.rxGet(OTC_USDT_PRICES_KEY).map {
            logger.info(it)
            gson.fromJson<List<DefaultPriceItem>>(it, object : TypeToken<List<DefaultPriceItem>>() {}.type)
        }
    }
}
