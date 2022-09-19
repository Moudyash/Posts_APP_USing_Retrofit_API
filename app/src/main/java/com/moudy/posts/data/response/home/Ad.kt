package com.moudy.posts.data.response.home


import com.google.gson.annotations.SerializedName

data class Ad(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("imgs")
    val imgs: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)