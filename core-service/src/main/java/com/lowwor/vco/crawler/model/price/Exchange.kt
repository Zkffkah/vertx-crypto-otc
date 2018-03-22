package com.lowwor.vco.crawler.model.price


const val HUOBI_NAME = "huobi.pro"
const val GANK_NAME = "gank.io"
const val OTCBTC_NAME = "otcbtc.com"
const val ZB_NAME = "zb.com"
const val LOCALBITCOINS_NAME = "localbitcoins.com"

const val HUOBI_URL = "huobi.pro"
const val GANK_URL = "gank.io"
const val OTCBTC_URL = "otcbtc.com"
const val ZB_URL = "zb.com"
const val LOCALBITCOINS_URL = "localbitcoins.com"

open class Exchange(val name: String? = null, val url: String? = null) {
    class Huobi : Exchange(HUOBI_NAME, HUOBI_URL)
    class Gank : Exchange(GANK_NAME, GANK_URL)
    class Otcbtc : Exchange(OTCBTC_NAME, OTCBTC_URL)
    class Zb : Exchange(ZB_NAME, ZB_URL)
    class LocalBitcoin : Exchange(LOCALBITCOINS_NAME, LOCALBITCOINS_URL)
}

open class Step(val from: Symbol? = null, val to: Symbol? = null, val rate: Float? = null) {
    class CnyToUsdt(rate: Float) : Step(Symbol.Cny(), Symbol.Usdt(), rate)
    class CnyToQc(rate: Float) : Step(Symbol.Cny(), Symbol.Qc(), rate)
    class CnyToElse(to: Symbol, rate: Float) : Step(Symbol.Cny(), to, rate)
    class QcToElse(to: Symbol, rate: Float) : Step(Symbol.Qc(), to, rate)
    class UsdtToElse(to: Symbol, rate: Float) : Step(Symbol.Usdt(), to, rate)
}

open class Symbol(val name: String? = null) {
    class Btc : Symbol("btc")
    class Usdt : Symbol("usdt")
    class Cny : Symbol("cny")
    class Qc : Symbol("qc")
}
