package com.example.sampleapplication.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserList(
    var page: Int? = null,
    var perPage: Int? = null,
    var total: Int? = null,
    var totalPages: Int? = null,
    var data: List<Datum> = ArrayList()
)