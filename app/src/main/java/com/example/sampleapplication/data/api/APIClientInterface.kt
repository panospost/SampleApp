package com.example.sampleapplication.data.api

import com.example.sampleapplication.data.model.CreateUserRequest
import com.example.sampleapplication.data.model.CreateUserResponse
import com.example.sampleapplication.data.model.LoginResponse
import com.example.sampleapplication.data.model.user.User
import com.example.sampleapplication.data.model.user.Users
import retrofit2.Response
import retrofit2.http.*


interface APIInterface {
    @GET("/api/users/{id}")
    suspend fun getSingleUser(@Path("id") id: Int): Response<User>

    @POST("/api/users")
    suspend fun createUser(@Body user: CreateUserRequest): Response<CreateUserResponse>

    @POST("/api/login")
    suspend fun loginUser(@Body user: CreateUserRequest): Response<LoginResponse>


    @PUT("/api/users/")
    suspend fun updateUser(@Path("id") id: Int): Response<CreateUserResponse>

    @PUT("/api/users/")
    suspend fun deleteUser(@Path("id") id: Int): Response<Int>

    @GET("/api/users?")
    suspend fun doGetUserList(@Query("page") page: Int?): Response<Users>

    @GET("/api/users?")
    suspend fun delayedUserList(@Query("delay") page: Int?): Response<Users>

}