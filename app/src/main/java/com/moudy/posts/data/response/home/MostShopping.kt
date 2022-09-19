package com.moudy.posts.data.response.home


import com.google.gson.annotations.SerializedName

data class MostShopping(
    @SerializedName("address")
    val address: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("img")
    val img: String?,
    @SerializedName("is_favourite")
    val isFavourite: Boolean?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("price")
    val price: String?,
    @SerializedName("star")
    val star: Int?,
    @SerializedName("stock")
    val stock: Int?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("vendor_name")
    val vendorName: String?
)