package com.dev.userdetailsapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String,
    @Expose(deserialize = false, serialize = false)
    var isCheck: Boolean
)

