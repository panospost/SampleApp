package com.example.sampleapplication.data.model.user

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ad(
              val company: String = "",
              val text: String = "",
              val url: String = "")