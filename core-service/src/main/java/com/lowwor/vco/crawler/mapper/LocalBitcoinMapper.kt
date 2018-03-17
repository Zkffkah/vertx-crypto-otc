package com.lowwor.vco.crawler.mapper

import com.lowwor.vco.crawler.model.price.OtcPriceItem
import com.lowwor.vco.crawler.model.price.LocalBitcoinOtcBtcPriceItem
import com.lowwor.vco.crawler.model.LocalBitcoinOtcRsp

/**
 * Created by lowwor on 2018/1/24.
 */
object LocalBitcoinMapper {
    fun convertToOneStepBtcEntrancePrice(localBitcoinOtcRsp: LocalBitcoinOtcRsp): OtcPriceItem =
            LocalBitcoinOtcBtcPriceItem(localBitcoinOtcRsp.pageData?.adList?.get(0)?.adData?.tempPrice?.toFloat())
}