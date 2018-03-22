package com.lowwor.vco.crawler.model.price

/**
 * Created by lowwor on 2018/1/24.
 */


open class OtcPriceItem(
        val totalRate: Float,
        val exchange: Exchange,
        val steps: List<Step>
)

 class HuobiOtcUsdtPriceItem(usdtRate: Float) : OtcPriceItem(usdtRate, Exchange.Huobi(), listOf(Step.CnyToUsdt(usdtRate)))

class HuobiOtcUsdtBtcPriceItem(usdtRate: Float, btcRate: Float) : OtcPriceItem(usdtRate * btcRate, Exchange.Huobi(),
        listOf(Step.CnyToUsdt(usdtRate), Step.UsdtToElse(Symbol.Btc(), btcRate)))

class GankOtcUsdtPriceItem(usdtRate: Float) : OtcPriceItem(usdtRate, Exchange.Gank(), listOf(Step.CnyToUsdt(usdtRate)))

class GankOtcUsdtBtcPriceItem(usdtRate: Float, btcRate: Float) : OtcPriceItem(usdtRate * btcRate, Exchange.Gank(),
        listOf(Step.CnyToUsdt(usdtRate), Step.UsdtToElse(Symbol.Btc(), btcRate)))

class OtcbtcUsdtPriceItem(usdtRate: Float) : OtcPriceItem(usdtRate, Exchange.Otcbtc(), listOf(Step.CnyToUsdt(usdtRate)))

class HuobiOtcBtcPriceItem(btcRate: Float) : OtcPriceItem(btcRate, Exchange.Huobi(), listOf(Step.CnyToElse(Symbol.Btc(), btcRate)))

class ZbQcBtcPriceItem(qc: Float, btcRate: Float) : OtcPriceItem(qc * btcRate, Exchange.Zb(),
        listOf(Step.CnyToQc(qc), Step.QcToElse(Symbol.Btc(), btcRate)))

class OtcbtcOtcBtcPriceItem(btcRate: Float) : OtcPriceItem(btcRate, Exchange.Otcbtc(), listOf(Step.CnyToElse(Symbol.Btc(), btcRate)))

class LocalBitcoinOtcBtcPriceItem(btcRate: Float) : OtcPriceItem(btcRate, Exchange.LocalBitcoin(), listOf(Step.CnyToElse(Symbol.Btc(), btcRate)))



