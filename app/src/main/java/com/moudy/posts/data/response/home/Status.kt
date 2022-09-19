package com.moudy.posts.data.response.home


import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("code")
    val code: String?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: Boolean?
)