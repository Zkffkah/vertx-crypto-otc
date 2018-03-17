package com.lowwor.vco.crawler.model

import com.google.gson.annotations.SerializedName

/**
 * Created by lowwor on 2018/1/23.
 */

data class GankOtcRsp(
        val result: Boolean, //true
        @SerializedName("appraised_rates") val appraisedRates: AppRaisedRates?
)

data class AppRaisedRates(
        @SerializedName("buy_rate") val buyRate: String, //7.12
        @SerializedName("sell_rate") val sellRate: String, //7.10
        @SerializedName("max_rate") val maxRate: String, //7.69
        @SerializedName("min_rate") val minRate: String, //6.66
        @SerializedName("rate_24h_go") val rate24hAgo: String //6.69
)