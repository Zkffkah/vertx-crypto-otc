package com.lowwor.vco.crawler.model

import com.google.gson.annotations.SerializedName

/**
 * Created by lowwor on 2018/1/23.
 */

data class LocalBitcoinOtcRsp(@SerializedName("pagination")
                              var pagination: Pagination? = null,
                              @SerializedName("data")
                              var pageData: PageData? = null)


data class Pagination(
        /**
         * next : https://localbitcoins.com/buy-bitcoins-online/CNY/.json?page=2
         */

        @SerializedName("next")
        var next: String? = null
)

data class PageData(
        @SerializedName("ad_count")
        var adCount: Int = 0,
        @SerializedName("ad_list")
        var adList: List<AdList>? = null
)

data class AdList(

        @SerializedName("data")
        var adData: AdData? = null,
        @SerializedName("actions")
        var actions: Actions? = null
)

data class AdData(

        @SerializedName("profile")
        var profile: Profile? = null,
        @SerializedName("require_feedback_score")
        var requireFeedbackScore: Int = 0,
        @SerializedName("hidden_by_opening_hours")
        var isHiddenByOpeningHours: Boolean = false,
        @SerializedName("trade_type")
        var tradeType: String? = null,
        @SerializedName("ad_id")
        var adId: Int = 0,
        @SerializedName("temp_price")
        var tempPrice: String? = null,
        @SerializedName("bank_name")
        var bankName: String? = null,
        @SerializedName("payment_window_minutes")
        var paymentWindowMinutes: Int = 0,
        @SerializedName("trusted_required")
        var isTrustedRequired: Boolean = false,
        @SerializedName("min_amount")
        var minAmount: String? = null,
        @SerializedName("visible")
        var isVisible: Boolean = false,
        @SerializedName("require_trusted_by_advertiser")
        var isRequireTrustedByAdvertiser: Boolean = false,
        @SerializedName("temp_price_usd")
        var tempPriceUsd: String? = null,
        @SerializedName("lat")
        var lat: Int = 0,
        @SerializedName("age_days_coefficient_limit")
        var ageDaysCoefficientLimit: String? = null,
        @SerializedName("is_local_office")
        var isIsLocalOffice: Boolean = false,
        @SerializedName("first_time_limit_btc")
        var firstTimeLimitBtc: Any? = null,
        @SerializedName("atm_model")
        var atmModel: Any? = null,
        @SerializedName("city")
        var city: String? = null,
        @SerializedName("location_string")
        var locationString: String? = null,
        @SerializedName("countrycode")
        var countrycode: String? = null,
        @SerializedName("currency")
        var currency: String? = null,
        @SerializedName("limit_to_fiat_amounts")
        var limitToFiatAmounts: String? = null,
        @SerializedName("created_at")
        var createdAt: String? = null,
        @SerializedName("max_amount")
        var maxAmount: String? = null,
        @SerializedName("lon")
        var lon: Int = 0,
        @SerializedName("sms_verification_required")
        var isSmsVerificationRequired: Boolean = false,
        @SerializedName("require_trade_volume")
        var requireTradeVolume: Double,
        @SerializedName("online_provider")
        var onlineProvider: String? = null,
        @SerializedName("max_amount_available")
        var maxAmountAvailable: String? = null,
        @SerializedName("msg")
        var msg: String? = null,
        @SerializedName("require_identification")
        var isRequireIdentification: Boolean = false,
        @SerializedName("email")
        var email: Any? = null,
        @SerializedName("volume_coefficient_btc")
        var volumeCoefficientBtc: String? = null
)

data class Profile(
        /**
         * username : tomparton
         * feedback_score : 100
         * trade_count : 30+
         * last_online : 2018-01-27T11:41:02+00:00
         * name : tomparton (30+; 100%)
         */

        @SerializedName("username")
        var username: String? = null,
        @SerializedName("feedback_score")
        var feedbackScore: Int = 0,
        @SerializedName("trade_count")
        var tradeCount: String? = null,
        @SerializedName("last_online")
        var lastOnline: String? = null,
        @SerializedName("name")
        var name: String? = null
)

data class Actions(
        /**
         * public_view : https://localbitcoins.com/ad/677347
         */

        @SerializedName("public_view")
        var publicView: String? = null
)