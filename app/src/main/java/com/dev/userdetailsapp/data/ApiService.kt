package com.dev.userdetailsapp.data

import com.dev.userdetailsapp.model.Users
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<Users>
}