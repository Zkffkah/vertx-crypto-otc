package com.lowwor.vco.crawler.model

/**
 * Created by lowwor on 2018/1/23.
 */

data class HuobiOtcRsp(
		val code: Int, //200
		val message: String, //成功
		val totalCount: Int, //87
		val pageSize: Int, //10
		val totalPage: Int, //9
		val currPage: Int, //1
		val data: List<HuobiPriceItem>,
		val success: Boolean //true
)

data class HuobiPriceItem(
		val id: Int, //32648
		val tradeNo: String, //v2c1dh2zp4
		val country: Int, //86
		val coinId: Int, //2
		val tradeType: Int, //1
		val merchant: Int, //1
		val currency: Int, //86
		val payMethod: String, //1
		val userId: Int, //1333867
		val userName: String, //老实人
		val isFixed: Boolean, //true
		val minTradeLimit: Float, //40000.0000000000
		val maxTradeLimit: Float, //500000.0000000000
		val fixedPrice: Float, //7.0700000000
		val calcRate: Float, //0E-10
		val price: Float, //7.07
		val tradeCount: Float, //178686.8642150000
		val isOnline: Boolean, //true
		val tradeMonthTimes: Int, //3050
		val appealMonthTimes: Int, //10
		val appealMonthWinTimes: Int //3
)