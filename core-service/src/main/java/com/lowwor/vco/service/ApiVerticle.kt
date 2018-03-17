package com.lowwor.vco.service

import com.google.gson.Gson
import com.lowwor.vco.base.RestfulApiVerticle
import com.lowwor.vco.api.model.response.ApiResonse
import com.lowwor.vco.api.model.GET_OTC_PRICES
import com.lowwor.vco.api.model.OTC_PRICES_SYMBOL_BTC
import com.lowwor.vco.api.model.OTC_PRICES_SYMBOL_USDT
import com.lowwor.vco.api.model.response.OtcPricesRsp
import com.lowwor.vco.data.dao.RedisDAO
import io.vertx.core.Future
import io.vertx.reactivex.ext.web.Router
import io.vertx.reactivex.ext.web.RoutingContext
import io.vertx.reactivex.ext.web.handler.BodyHandler
import io.vertx.reactivex.redis.RedisClient


class ApiVerticle : RestfulApiVerticle() {

    private val HOST = "localhost"
    private val PORT = 8098
    lateinit var redisDao: RedisDAO
    var gson: Gson = Gson()


    @Throws(Exception::class)
    override fun start(startFuture: Future<Void>) {
        redisDao = RedisDAO(RedisClient.create(vertx))


        val router = Router.router(vertx)
        // Enable HTTP Body parse.
        router.route().handler(BodyHandler.create())
        // Enable CORS.
        enableCorsSupport(router)

        router.get(GET_OTC_PRICES).handler(this::handleGetOtcPrices)


        val host = config().getString("http.address", HOST)
        val port = config().getInteger("http.port", PORT)
        createHttpServer(router, host, port)
                .subscribe(
                        startFuture::complete
                        , startFuture::fail)
    }


    private fun handleGetOtcPrices(context: RoutingContext) {
        val symbol = context.request().getParam("symbol")
        if (symbol == null) {
            badRequest(context)
            return
        }
        when (symbol) {
            OTC_PRICES_SYMBOL_BTC -> {
                sendResponse(context, redisDao.getOtcBtcPrices()) {
                    gson.toJson(ApiResonse(0, "", OtcPricesRsp(it)))
                }
            }
            OTC_PRICES_SYMBOL_USDT -> {
                sendResponse(context, redisDao.getOtcUsdtPrices()) {

                    gson.toJson(ApiResonse(0, "", OtcPricesRsp(it)))
                }
            }
            else -> {
                badRequest(context)
            }
        }
    }
}
