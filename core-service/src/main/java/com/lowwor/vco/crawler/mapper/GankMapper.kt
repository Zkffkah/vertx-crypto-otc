package com.lowwor.vco.crawler.mapper

import com.lowwor.vco.crawler.model.price.OtcPriceItem
import com.lowwor.vco.crawler.model.price.GankOtcUsdtBtcPriceItem
import com.lowwor.vco.crawler.model.price.GankOtcUsdtPriceItem
import com.lowwor.vco.crawler.model.GankOtcRsp

/**
 * Created by lowwor on 2018/1/24.
 */

object GankMapper {

    fun convertToOneStepUsdtEntrancePrice(gankOtcRsp: GankOtcRsp): OtcPriceItem =
            GankOtcUsdtPriceItem(gankOtcRsp.appraisedRates?.buyRate?.toFloat())

    fun convertToTwoStepBtcEntrancePrice(price: Float): OtcPriceItem =
            GankOtcUsdtBtcPriceItem(price)
}