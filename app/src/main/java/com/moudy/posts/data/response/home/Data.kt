package com.moudy.posts.data.response.home


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("ads")
    val ads: List<Ad?>?,
    @SerializedName("categories")
    val categories: List<Category?>?,
    @SerializedName("mostBooking")
    val mostBooking: List<MostBooking?>?,
    @SerializedName("mostOrder")
    val mostOrder: List<MostOrder?>?,
    @SerializedName("mostShopping")
    val mostShopping: List<MostShopping?>?
)