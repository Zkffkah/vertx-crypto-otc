package com.lowwor.vco.api.model.response

class ApiResonse<out T>(
        val code: Int,
        val msg: String?,
        val data: T
)