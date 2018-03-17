package com.lowwor.vco.crawler.mapper

import com.lowwor.vco.crawler.model.price.OtcPriceItem
import com.lowwor.vco.crawler.model.price.OtcbtcOtcBtcPriceItem
import com.lowwor.vco.crawler.model.price.OtcbtcUsdtPriceItem
import com.lowwor.vco.crawler.model.OtcbtcPriceItemRsp

/**
 * Created by lowwor on 2018/1/24.
 */
object OtcbtcMapper {

    fun convertToOneStepUsdtEntrancePrice(otcbtcPriceItemRsp: OtcbtcPriceItemRsp): OtcPriceItem =
            OtcbtcUsdtPriceItem(otcbtcPriceItemRsp.price.toFloat())

    fun convertToOneStepBtcEntrancePrice(otcbtcPriceItemRsp: OtcbtcPriceItemRsp): OtcPriceItem =
            OtcbtcOtcBtcPriceItem(otcbtcPriceItemRsp.price.toFloat())

}