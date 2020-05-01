package com.example.sampleapplication.data.model.user

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
                 val ad: Ad,
                 val data: Data
)