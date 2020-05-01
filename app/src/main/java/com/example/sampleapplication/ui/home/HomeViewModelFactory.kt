package com.example.sampleapplication.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sampleapplication.data.HomeRepository
import com.example.sampleapplication.data.api.APIClient

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class HomeViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(
               repository = HomeRepository(
                    APIClient.userApi
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}