package com.moudy.posts.view.activity

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.moudy.posts.data.PostItem
import com.moudy.posts.databinding.ActivityAddPostBinding
import com.moudy.posts.databinding.ActivityAddPostBinding.inflate
import com.moudy.posts.databinding.ActivityMainBinding
import com.moudy.posts.databinding.ActivitySingelPostBinding.inflate
import com.moudy.posts.databinding.LiPostBinding.inflate
import com.moudy.posts.network.ApiService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddPost : AppCompatActivity() {
    private lateinit var binding:ActivityAddPostBinding
            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                binding = ActivityAddPostBinding.inflate(layoutInflater)
                setContentView(binding.root)
binding.btn.setOnClickListener(){

    var hashMap : HashMap<String, String>
            = HashMap<String, String> (2)
    hashMap.put("title",binding.posttitle.toString())
    hashMap.put("body",binding.postbody.toString())

    addpost(hashMap)
}
    }
    fun addpost(hashMap: HashMap<String,String>){
                ApiService.client.addNewPost(hashMap).enqueue(object :Callback<ResponseBody>{
                            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                                if (response.code() in 200..299){
                                    Log.d("done", "addNewPost() onResponse: Error ${response.code()}")

                                }
                                else{
                                    Log.d(TAG, "addNewPost() onResponse: Error ${response.code()}")
                                    Log.d(TAG, "addNewPost() onResponse: Error ${response.errorBody()?.string()?:"error"}")
                                }
                            }

                            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                                Log.d(TAG, "addNewPost() onFailure: ${t.message}")
                            }
                        })  }
}


