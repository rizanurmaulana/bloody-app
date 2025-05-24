package com.example.bloody_app.ui.authentication.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.engine.Resource
import com.example.bloody_app.model.LoginResponse
import com.example.bloody_app.repository.AuthRepository
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val repository = AuthRepository()

    val loginResponse = MutableLiveData<LoginResponse?>()
    val errorMessage = MutableLiveData<String?>()
    val isLoading = MutableLiveData<Boolean>()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val response = repository.login(email, password)
                if (response.isSuccessful) {
                    loginResponse.value = response.body()
                    errorMessage.value = null
                } else {
                    loginResponse.value = null
                    errorMessage.value = "Login gagal: ${response.message()}"
                }
            } catch (e: Exception) {
                loginResponse.value = null
                errorMessage.value = "Terjadi kesalahan: ${e.localizedMessage}"
            } finally {
                isLoading.value = false
            }
        }
    }
}

