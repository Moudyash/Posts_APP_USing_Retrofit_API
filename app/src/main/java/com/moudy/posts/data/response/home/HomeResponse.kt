package com.moudy.posts.data.response.home


import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("status")
    val status: Status?
)