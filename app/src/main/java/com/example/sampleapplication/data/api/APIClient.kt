package com.example.sampleapplication.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object APIClient {

    private val interceptor = LoggingInterceptor()

    private val apiClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().client(apiClient)
            .baseUrl("https://reqres.in")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(apiClient)
            .build()
    }

    val userApi: APIInterface = getRetrofit().create(APIInterface::class.java)

}
