package com.dev.userdetailsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.userdetailsapp.model.Users
import com.dev.userdetailsapp.repository.UserRepository
import com.dev.userdetailsapp.util.Resource
import kotlinx.coroutines.launch

class UserDetailViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val userDetailsList = MutableLiveData<Resource<List<Users>>>()

    init {
        fetchUserDetails()
    }


    private fun fetchUserDetails() {
        viewModelScope.launch {
            userDetailsList.postValue(Resource.loading(null))
            try {
                val userDetails = userRepository.getUsers()
                userDetailsList.postValue(Resource.success(userDetails))
            } catch (e: Exception) {
                userDetailsList.postValue(Resource.error(e.toString(), null))
            }
        }
    }

    fun getUsers(): LiveData<Resource<List<Users>>> {
        return userDetailsList
    }

}