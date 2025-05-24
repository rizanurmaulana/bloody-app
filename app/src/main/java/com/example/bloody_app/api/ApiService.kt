package com.example.bloody_app.api

import com.example.bloody_app.model.LoginRequest
import com.example.bloody_app.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}
