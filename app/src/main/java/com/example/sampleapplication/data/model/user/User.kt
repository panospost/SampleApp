package com.example.sampleapplication.data.model.user

import com.squareup.moshi.Json

data class User(@Json(name = "ad")
                 val ad: Ad,
                 @Json(name = "data")
                 val data: Data
)