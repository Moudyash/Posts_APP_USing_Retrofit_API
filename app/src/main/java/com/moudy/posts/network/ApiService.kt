package com.moudy.posts.network

import com.google.gson.GsonBuilder
import com.moudy.posts.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


val gson = GsonBuilder().setLenient().create()


val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create(gson))
    .baseUrl(BASE_URL)
    .build()

object ApiService {
    val client: ApiClient by lazy {
        retrofit.create(ApiClient::class.java)
    }
}
