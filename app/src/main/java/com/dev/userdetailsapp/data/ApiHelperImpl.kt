package com.dev.userdetailsapp.data

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override suspend fun getUsers() = apiService.getUsers()
}