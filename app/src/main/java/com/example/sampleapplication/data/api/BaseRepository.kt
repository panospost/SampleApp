package com.example.sampleapplication.data.api

import android.util.Log
import retrofit2.Response
import java.io.IOException

open class BaseRepository {
    suspend fun <T : Any> safeApiCall(call : suspend()-> Response<T>, error : String) :  T?{
        val result = newsApiOutput(call, error)
        var output : T? = null
        when(result){
            is Result.Success ->
                output = result.output
            is Result.Error -> Log.e("Error", "The $error and the ${result.exception}")
        }
        return output

    }
    private suspend fun<T : Any> newsApiOutput(call: suspend()-> Response<T> , error: String) : Result<T>{
        val response = call.invoke()
        return if (response.isSuccessful)
            Result.Success(response.body()!!)
        else
            Result.Error(IOException("OOps .. Something went wrong due to  $error"))
    }
}