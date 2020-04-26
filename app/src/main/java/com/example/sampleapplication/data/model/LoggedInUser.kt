package com.example.sampleapplication.data.model


import com.squareup.moshi.JsonClass

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
@JsonClass(generateAdapter = true)
data class LoggedInUser(
    val userId: String,
    val displayName: String
)
