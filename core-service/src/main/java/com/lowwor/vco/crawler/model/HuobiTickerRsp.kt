package com.lowwor.vco.crawler.model

import java.math.BigInteger

/**
 * Created by lowwor on 2018/1/27.
 */

//"tick": {
//	"id": 消息id,
//	"ts": 最新成交时间,
//	"data": [
//	{
//		"id": 成交id,
//		"price": 成交价钱,
//		"amount": 成交量,
//		"direction": 主动成交方向,
//		"ts": 成交时间
//	}
//	]
//}

data class HuobiTickerRsp(
		val status: String, //ok
		val ch: String, //market.btcusdt.trade.detail
		val ts: Long, //1489473346905
		val tick: HuobiTicker
)

data class HuobiTicker(
		val id: BigInteger, //600848670
		val ts: Long, //1489464451000
		val data: List<HuobiTickerData>
)

data class HuobiTickerData(
		val id: BigInteger, //600848670
		val price: Double, //7962.62
		val amount: Double, //0.0122
		val direction: String, //buy
		val ts: Long //1489464451000
)