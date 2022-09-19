package com.moudy.posts.data.response.home


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("icon")
    val icon: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("type")
    val type: String?
)