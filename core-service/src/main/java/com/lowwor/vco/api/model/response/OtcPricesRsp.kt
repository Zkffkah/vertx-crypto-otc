package com.lowwor.vco.api.model.response

import com.lowwor.vco.crawler.model.price.OtcPriceItem

data class OtcPricesRsp(
        val prices: List<OtcPriceItem>
)