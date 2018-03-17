package com.lowwor.vco.crawler.model.price

/**
 * Created by lowwor on 2018/1/24.
 */


const val HUOBI_NAME = "huobi.pro"
const val GANK_NAME = "gank.io"
const val OTCBTC_NAME = "otcbtc.com"
const val ZB_NAME = "zb.com"
const val LOCALBITCOINS_NAME = "localbitcoins.com"

sealed class OtcPriceItem {
    abstract val price: Float?
    abstract val name: String?
    abstract val step: String?
}

data class DefaultPriceItem(override val price: Float?,
                            override val name: String?,
                            override val step: String?) : OtcPriceItem()

data class HuobiOtcUsdtPriceItem(override val price: Float?,
                                 override val name: String? = HUOBI_NAME,
                                 override val step: String? = "cny -> usdt") : OtcPriceItem()

data class HuobiOtcUsdtBtcPriceItem(override val price: Float?,
                                    override val name: String? = HUOBI_NAME,
                                    override val step: String? = "cny -> usdt \n usdt -> btc"
) : OtcPriceItem()

data class GankOtcUsdtPriceItem(override val price: Float?,
                                override val name: String = GANK_NAME,
                                override val step: String? = "cny -> usdt") : OtcPriceItem()

data class GankOtcUsdtBtcPriceItem(override val price: Float?,
                                   override val name: String = GANK_NAME,
                                   override val step: String? = "cny -> usdt \n usdt -> btc") : OtcPriceItem()

data class OtcbtcUsdtPriceItem(override val price: Float?,
                               override val name: String = OTCBTC_NAME,
                               override val step: String? = "cny -> usdt") : OtcPriceItem()

data class HuobiOtcBtcPriceItem(override val price: Float?,
                                override val name: String = HUOBI_NAME,
                                override val step: String? = "cny -> btc") : OtcPriceItem()

data class ZbQcBtcPriceItem(override val price: Float?,
                            override val name: String = ZB_NAME,
                            override val step: String? = "cny -> qc \n qc -> btc") : OtcPriceItem()

data class OtcbtcOtcBtcPriceItem(override val price: Float?,
                                 override val name: String = OTCBTC_NAME,
                                 override val step: String? = "cny -> btc") : OtcPriceItem()

data class LocalBitcoinOtcBtcPriceItem(override val price: Float?,
                                       override val name: String = LOCALBITCOINS_NAME,
                                       override val step: String? = "cny -> btc") : OtcPriceItem()



