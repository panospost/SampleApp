package com.example.sampleapplication.data.model


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class MultipleResource (var page: Int? = null,
                        var perPage: Int? = null,
                        var total: Int? = null,
                        var totalPages: Int? = null,
                        var data: List<Datum>? = null)

@JsonClass(generateAdapter = true)
data class Datum(
    var id: Int? = null,
    var name: String? = null,
    var year: Int? = null,
    var pantoneValue: String? = null
)