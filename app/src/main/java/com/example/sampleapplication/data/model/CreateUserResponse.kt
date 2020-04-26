package com.example.sampleapplication.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreateUserResponse (
    var name: String? = null,
    var job: String? = null,
    var id: String? = null,
    var createdAt: String? = null
)