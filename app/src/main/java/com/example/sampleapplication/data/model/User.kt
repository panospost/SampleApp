package com.example.sampleapplication.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class User(
    var name: String,
    var job: String? = null,
    var id: String? = null,
    var createdAt: String? = null
)
