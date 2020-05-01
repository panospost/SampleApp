package com.example.sampleapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sampleapplication.data.HomeRepository
import com.example.sampleapplication.data.model.user.Data
import com.example.sampleapplication.data.model.user.User
import com.example.sampleapplication.data.model.user.Users
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {
    //create a new Job
    private val parentJob = Job()
    //create a coroutine context with the job and the dispatcher
    private val coroutineContext : CoroutineContext get() = parentJob + Dispatchers.Default
    //create a coroutine scope with the coroutine context
    private val scope = CoroutineScope(coroutineContext)

    private val _users = MutableLiveData<List<Data>>()
    val users: LiveData<List<Data>> = _users

    fun getUsers(page: Int){

        scope.launch{
            val result = repository.getUsers(page)
            if(result is Users) {
                _users.postValue(
                    result.data
                )
            } else {
                _users.postValue(
                    mutableListOf()
                )
            }
        }

    }

    init {
        getUsers(2)
    }

}