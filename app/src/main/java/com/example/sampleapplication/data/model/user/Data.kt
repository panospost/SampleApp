package com.example.sampleapplication.data.model.user

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
                val lastName: String = "",
                val id: Int = 0,
                val avatar: String = "",
                val firstName: String = "",
                val email: String = "")