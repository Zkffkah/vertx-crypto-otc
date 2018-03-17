package com.lowwor.vco.crawler.model

/**
 * Created by lowwor on 2018/1/23.
 */


data class GankTickerRsp(
		val result: String, //true
		val last: Double, //11220.71
		val lowestAsk: Double, //11315
		val highestBid: Double, //11221.1
		val percentChange: Double, //6.6603773584906
		val baseVolume: Double, //6337965.94
		val quoteVolume: Double, //577.6993
		val high24hr: Double, //11361.25
		val low24hr: Double //10464.45
)