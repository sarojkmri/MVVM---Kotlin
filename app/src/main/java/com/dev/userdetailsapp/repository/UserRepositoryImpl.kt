package com.dev.userdetailsapp.repository

import com.dev.userdetailsapp.data.ApiHelper

class UserRepositoryImpl(private val apiHelper: ApiHelper) : UserRepository {
    override suspend fun getUsers() = apiHelper.getUsers()
}