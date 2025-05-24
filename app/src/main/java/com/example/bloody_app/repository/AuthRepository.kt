package com.example.bloody_app.repository

import com.example.bloody_app.api.ApiClient
import com.example.bloody_app.model.LoginRequest
import com.example.bloody_app.model.LoginResponse
import retrofit2.Response

class AuthRepository {
    private val api = ApiClient.apiService

    suspend fun login(email: String, password: String): Response<LoginResponse> {
        return api.login(LoginRequest(email, password))
    }
}
