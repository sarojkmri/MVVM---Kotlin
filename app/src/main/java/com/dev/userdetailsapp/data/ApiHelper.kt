package com.dev.userdetailsapp.data

import com.dev.userdetailsapp.model.Users

interface ApiHelper {
    suspend fun getUsers(): List<Users>
}