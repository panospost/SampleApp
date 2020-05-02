package com.example.sampleapplication.data

import com.example.sampleapplication.data.api.APIInterface
import com.example.sampleapplication.data.api.BaseRepository
import com.example.sampleapplication.data.model.user.Users

class HomeRepository(private val apiInterface: APIInterface) : BaseRepository() {

    suspend fun getUsers(page: Int): Users? {
        return safeApiCall(
            call = {apiInterface.doGetUserList(page)},
            error = "Error loging in user"
        )
    }

}