package com.lowwor.vco.crawler.mapper

import com.lowwor.vco.crawler.model.GankOtcRsp
import com.lowwor.vco.crawler.model.GankTickerRsp
import com.lowwor.vco.crawler.model.price.GankOtcUsdtBtcPriceItem
import com.lowwor.vco.crawler.model.price.GankOtcUsdtPriceItem
import com.lowwor.vco.crawler.model.price.OtcPriceItem

/**
 * Created by lowwor on 2018/1/24.
 */

object GankMapper {

    fun convertToOneStepUsdtEntrancePrice(gankOtcRsp: GankOtcRsp): OtcPriceItem =
            GankOtcUsdtPriceItem(gankOtcRsp.appraisedRates?.buyRate?.toFloat() ?: 0F)

    fun convertToTwoStepBtcEntrancePrice(gankOtcUsdtRsp: GankOtcRsp, gankTickerBtcRsp: GankTickerRsp): OtcPriceItem =
            GankOtcUsdtBtcPriceItem(gankOtcUsdtRsp.appraisedRates?.buyRate!!.toDouble().toFloat(), gankTickerBtcRsp.last.toFloat())
}