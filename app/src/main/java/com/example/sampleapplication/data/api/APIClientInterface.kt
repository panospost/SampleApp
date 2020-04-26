package com.example.sampleapplication.data.api

import com.example.sampleapplication.data.model.MultipleResource
import com.example.sampleapplication.data.model.User
import com.example.sampleapplication.data.model.UserList
import retrofit2.Response
import retrofit2.http.*


interface APIInterface {
    @GET("/api/unknown")
    suspend fun doGetListResources(): MultipleResource

    @POST("/api/users")
    suspend fun createUser(@Body user: User?): Response<User>

    @GET("/api/users?")
    suspend fun doGetUserList(@Query("page") page: String?): UserList

    @FormUrlEncoded
    @POST("/api/users?")
    suspend fun doCreateUserWithField(
        @Field("name") name: String?,
        @Field("job") job: String?
    ): UserList
}