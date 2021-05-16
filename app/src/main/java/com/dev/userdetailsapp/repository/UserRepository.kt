package com.dev.userdetailsapp.repository

import com.dev.userdetailsapp.model.Users

interface UserRepository {
    suspend fun getUsers(): List<Users>
}