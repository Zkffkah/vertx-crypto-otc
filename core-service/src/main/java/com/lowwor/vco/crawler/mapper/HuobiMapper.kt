package com.lowwor.vco.crawler.mapper

import com.lowwor.vco.crawler.model.price.HuobiOtcBtcPriceItem
import com.lowwor.vco.crawler.model.price.HuobiOtcUsdtBtcPriceItem
import com.lowwor.vco.crawler.model.price.HuobiOtcUsdtPriceItem
import com.lowwor.vco.crawler.model.price.OtcPriceItem
import com.lowwor.vco.crawler.model.HuobiOtcRsp

/**
 * Created by lowwor on 2018/1/24.
 */
object HuobiMapper {

    fun convertToTwoStepBtcToEntrancePrice(price: Float): OtcPriceItem =
            HuobiOtcUsdtBtcPriceItem(price)

    fun convertToOneStepBtcEntrancePrice(huobiOtcRsp: HuobiOtcRsp): OtcPriceItem =
            HuobiOtcBtcPriceItem(huobiOtcRsp.data[0].price)

    fun convertToOneStepUsdtEntrancePrice(huobiOtcRsp: HuobiOtcRsp): OtcPriceItem =
            HuobiOtcUsdtPriceItem(huobiOtcRsp.data[0].price)


}