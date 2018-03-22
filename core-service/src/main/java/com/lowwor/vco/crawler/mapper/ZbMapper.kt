package com.lowwor.vco.crawler.mapper

import com.lowwor.vco.crawler.model.ZbTickerRsp
import com.lowwor.vco.crawler.model.price.OtcPriceItem
import com.lowwor.vco.crawler.model.price.ZbQcBtcPriceItem

/**
 * Created by lowwor on 2018/1/24.
 */
object ZbMapper {

    fun convertToQcBtcEntrancePrice(zbTickerRsp: ZbTickerRsp): OtcPriceItem =
            ZbQcBtcPriceItem(1F, zbTickerRsp.ticker.last.toFloat())

}