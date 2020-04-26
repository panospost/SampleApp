package com.example.sampleapplication.data

import com.example.sampleapplication.data.api.APIInterface
import com.example.sampleapplication.data.api.BaseRepository
import com.example.sampleapplication.data.model.LoggedInUser
import com.example.sampleapplication.data.model.User

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(private val apiInterface: APIInterface) : BaseRepository() {

    // in-memory cache of the loggedInUser object
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    fun logout() {
        user = null
        //dataSource.logout()
    }

    suspend fun login(username: String, password: String): User? {
        val user = User(username, password)
        return safeApiCall(
            //await the result of deferred type
            call = {apiInterface.createUser(user)},
            error = "Error fetching news"
            //convert to mutable list
        )
    }


//    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
//        this.user = loggedInUser
//        // If user credentials will be cached in local storage, it is recommended it be encrypted
//        // @see https://developer.android.com/training/articles/keystore
//    }
}
