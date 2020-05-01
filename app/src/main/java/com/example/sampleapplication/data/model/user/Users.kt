package com.example.sampleapplication.data.model.user

import com.example.sampleapplication.data.model.user.Ad
import com.example.sampleapplication.data.model.user.Data
import com.squareup.moshi.Json

data class Users(@Json(name = "per_page")
                 val perPage: Int = 0,
                 @Json(name = "total")
                 val total: Int = 0,
                 @Json(name = "ad")
                 val ad: Ad,
                 @Json(name = "data")
                 val data: List<Data>?,
                 @Json(name = "page")
                 val page: Int = 0,
                 @Json(name = "total_pages")
                 val totalPages: Int = 0)