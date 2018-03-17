package com.lowwor.vco.crawler.model

import com.google.gson.annotations.SerializedName


/**
 * Created by lowwor on 2018/1/23.
 */

data class OtcbtcPriceItemRsp(
        @SerializedName("type") val type: String,
        @SerializedName("currency") val currency: String,
        @SerializedName("max_amount") val maxAmount: String,
        @SerializedName("minimum_amount") val minimumAmount: String,
        @SerializedName("offer_terms") val offerTerms: String,
        @SerializedName("created_at") val createdAt: String,
        @SerializedName("updated_at") val updatedAt: String,
        @SerializedName("fiat_currency") val fiatCurrency: String,
        @SerializedName("price") val price: String,
        @SerializedName("minimum_price") val minimumPrice: String,
        @SerializedName("margin") val margin: String,
        @SerializedName("payment_window") val paymentWindow: Int,
        @SerializedName("trading_instruction") val tradingInstruction: String,
        @SerializedName("aasm_state") val aasmState: String,
        @SerializedName("expired_at") val expiredAt: String,
        @SerializedName("buyer_phone_confirmed") val buyerPhoneConfirmed: Boolean,
        @SerializedName("buyer_min_successful_orders") val buyerMinSuccessfulOrders: Int,
        @SerializedName("orders_count") val ordersCount: Int,
        @SerializedName("token") val token: String,
        @SerializedName("need_taker_identified") val needTakerIdentified: Boolean,
        @SerializedName("crypto_source") val cryptoSource: String,
        @SerializedName("is_single") val isSingle: Boolean,
        @SerializedName("need_advanced_identity_identified") val needAdvancedIdentityIdentified: Boolean,
        @SerializedName("affordable_amount") val affordableAmount: String,
        @SerializedName("user") val user: User,
        @SerializedName("payment_types") val paymentTypes: List<PaymentType>
)

data class User(
        @SerializedName("name") val name: String,
        @SerializedName("locale") val locale: String,
        @SerializedName("email") val email: String,
        @SerializedName("successful_trading_orders_count") val successfulTradingOrdersCount: Int,
        @SerializedName("avg_recieved_reviews_rating") val avgRecievedReviewsRating: Float,
        @SerializedName("trusted_count") val trustedCount: Int,
        @SerializedName("image_url") val imageUrl: String,
        @SerializedName("alive") val alive: Boolean,
        @SerializedName("email_confirmed") val emailConfirmed: Boolean,
        @SerializedName("identify_confirmed") val identifyConfirmed: Boolean,
        @SerializedName("advanced_identity_confirmed") val advancedIdentityConfirmed: Boolean
)

data class PaymentType(
        @SerializedName("name") val name: String,
        @SerializedName("code") val code: String
)


