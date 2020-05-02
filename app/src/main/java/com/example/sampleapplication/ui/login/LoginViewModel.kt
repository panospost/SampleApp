package com.example.sampleapplication.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import com.example.sampleapplication.data.LoginRepository

import com.example.sampleapplication.R
import com.example.sampleapplication.data.model.CreateUserRequest
import com.example.sampleapplication.data.model.LoginResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {
    //create a new Job
    private val parentJob = Job()
    //create a coroutine context with the job and the dispatcher
    private val coroutineContext : CoroutineContext get() = parentJob + Dispatchers.Default
    //create a coroutine scope with the coroutine context
    private val scope = CoroutineScope(coroutineContext)

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isloggedIn: LiveData<Boolean> = _isLoggedIn

    fun login(username: String, password: String): Boolean {
        val fakename = "eve.holt@reqres.in"
        val fakepass = "cityslicka"
        scope.launch {
             val result = loginRepository.login(CreateUserRequest(email = fakename,id = null,name = null, password = fakepass))
             if (result is LoginResponse) {
//                 val getUser = loginRepository.getLoggedUser(id = 2);
//                 if( getUser is User) {
                     _loginResult.postValue(
                         LoginResult(success = LoggedInUserView(displayName = "some name"))
                     )
//                 }

             } else {
                 _loginResult.postValue(
                     LoginResult(error = R.string.login_failed)
                 )
             }
         }
        return true
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}
