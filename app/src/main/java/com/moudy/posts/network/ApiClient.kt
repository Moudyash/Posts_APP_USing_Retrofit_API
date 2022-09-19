package com.moudy.posts.network

import com.moudy.posts.data.GetAllPosts
import com.moudy.posts.data.PostItem
import com.moudy.posts.data.response.home.HomeResponse
import com.moudy.posts.utils.BASE_URL
import com.moudy.posts.utils.USER_TOKEN
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiClient {


    @GET
    fun getPosts(
        @Url url: String
    ): Call<GetAllPosts>

    @GET("posts/{post_id}")
    fun getSinglePost(
        @Path("post_id") postId: Int
    ): Call<PostItem>

    @FormUrlEncoded
    @POST("posts")
    fun addNewPost(
//        @Field("title") title:String,
//        @Field("body") body:String,
        @FieldMap hashMap: HashMap<String, String>
    ): Call<ResponseBody>


    @FormUrlEncoded
    @POST("auth/login")
    fun loginByUsername(
        @Field("username") username: String,
        @Field("password") password: String,
    ): Call<PostItem>


    @GET("home")
    fun getHome(
        @Header("Authorization") token: String = USER_TOKEN
    ): Call<HomeResponse>

}