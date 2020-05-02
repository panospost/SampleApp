package com.example.sampleapplication.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginResponse(
    var token: String?
)