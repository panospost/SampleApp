package com.example.sampleapplication.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CreateUserRequest(
    var name: String?,
    var id: String?,
    var email: String?,
    var password: String?
)
