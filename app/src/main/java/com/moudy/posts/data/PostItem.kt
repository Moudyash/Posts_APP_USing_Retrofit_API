package com.moudy.posts.data


import com.google.gson.annotations.SerializedName

data class PostItem(
    @SerializedName("body")
    val bodyString: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("userId")
    val userId: Int?
)