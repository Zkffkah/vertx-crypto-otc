package com.lowwor.vco.crawler.model

/**
 * Created by lowwor on 2018/1/23.
 */

//high : 最高价
//low : 最低价
//buy : 买一价
//sell : 卖一价
//last : 最新成交价
//vol : 成交量(最近的24小时)

data class ZbTickerRsp(
        val ticker: ZbTicker,
        val date: String //1507875747359
)

data class ZbTicker(
        val vol: String, //40.463
        val last: String, //0.899999
        val sell: String, //0.5
        val buy: String, //0.225
        val high: String, //0.899999
        val low: String //0.081
)

