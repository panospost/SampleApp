package com.example.sampleapplication.data.model.user

import com.example.sampleapplication.data.model.user.Ad
import com.example.sampleapplication.data.model.user.Data
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Users(
                 val perPage: Int = 0,
                 val total: Int = 0,
                 val ad: Ad,
                 val data: List<Data>?,
                 val page: Int = 0,
                 val totalPages: Int = 0)