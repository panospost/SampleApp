package com.example.sampleapplication.data.model.user

import com.squareup.moshi.Json

data class Data(@Json(name = "last_name")
                val lastName: String = "",
                @Json(name = "id")
                val id: Int = 0,
                @Json(name = "avatar")
                val avatar: String = "",
                @Json(name = "first_name")
                val firstName: String = "",
                @Json(name = "email")
                val email: String = "")