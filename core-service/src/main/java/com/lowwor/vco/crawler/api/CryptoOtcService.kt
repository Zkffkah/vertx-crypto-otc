package com.lowwor.vco.crawler.api

import com.lowwor.vco.crawler.model.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by lowwor on 2018/1/23.
 */
const val GANK_OTC_SYMBOL_USDT = "USDT_CNY"

const val HUOBI_OTC_COIN_ID_BTC = 1
const val HUOBI_OTC_COIN_ID_USDT = 2

const val OTCBTC_OTC_CURRENCY_USDT = "usdt"
const val OTCBTC_OTC_CURRENCY_BTC = "btc"

const val GANK_TICKER_BTC_USDT = "btc_usdt"
const val ZB_TICKER_BTC_QC = "btc_qc"
const val HUOBI_TICKER_BTC_USDT = "btcusdt"

interface CryptoOtcService {

    //    usdt: https://gate.io/json_svr/query_push?type=push_main_rates&symbol=USDT_CNY
    @GET("http://gateio.io/json_svr/query_push")
    fun getGankOtcUsdtPrice(@Query("symbol") symbol: String = GANK_OTC_SYMBOL_USDT,
                            @Query("type") type: String = "push_main_rates"
    ): Observable<GankOtcRsp>


    // usdt:   https://api-otc.huobi.pro/v1/otc/trade/list/public?coinId=2&tradeType=1&currentPage=1&online=1&range=0
    @GET("https://api-otc.huobipro.com/v1/otc/trade/list/public")
    fun getHuobiOtcPrice(@Query("coinId") coinId: Int = HUOBI_OTC_COIN_ID_USDT,
                         @Query("tradeType") tradeType: Int = 1,
                         @Query("currPage") currentPage: Int = 1,
                         @Query("online") online: Int = 1,
                         @Query("range") range: Int = 10): Observable<HuobiOtcRsp>


    //    https://otcbtc.com/api/v0/public/offers?limit=20&page=1&currency=btc&fiat_currency=cny&type=SellOffer
    //    Client-Version-Tag 0.10.0
    @GET("https://otcbtc.com/api/v0/public/offers")
    @Headers("Client-Version-Tag:0.10.0")
    fun getOtcbtcOtcPrice(
            @Query("currency") currency: String = OTCBTC_OTC_CURRENCY_USDT,
            @Query("limit") limit: Int = 10,
            @Query("fiat_currency") fiatCurrency: String = "cny",
            @Query("type") paymentType: String = "SellOffer"
    ): Observable<List<OtcbtcPriceItemRsp>>

    //    https://localbitcoins.com/buy-bitcoins-online/CNY/.json
    @GET("https://localbitcoins.com/buy-bitcoins-online/CNY/.json")
    fun getLocalBitcoinOtcPrice(): Observable<LocalBitcoinOtcRsp>

    //   gate.io http://data.gate.io/api2/1/ticker/btc_usdt
    @GET("http://data.gate.io/api2/1/ticker/{ticker}")
    fun getGankTickerPrice(@Path("ticker") ticker: String = GANK_TICKER_BTC_USDT): Observable<GankTickerRsp>

    //    http://api.zb.com/data/v1/ticker?market=btc_usdt
    @GET("http://api.zb.com/data/v1/ticker")
    fun getZbTickerPrice(@Query("market") market: String = ZB_TICKER_BTC_QC): Observable<ZbTickerRsp>

    //    https://api.huobi.pro/market/trade?symbol=btcusdt
    @GET("https://api.huobi.pro/market/trade?")
    fun getHuobiTickerPrice(@Query("symbol") symbol: String = HUOBI_TICKER_BTC_USDT): Observable<HuobiTickerRsp>

}