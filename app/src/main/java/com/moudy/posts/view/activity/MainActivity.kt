package com.moudy.posts.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.moudy.posts.R
import com.moudy.posts.adapter.PostAdapter
import com.moudy.posts.data.GetAllPosts
import com.moudy.posts.data.PostItem
import com.moudy.posts.data.response.home.HomeResponse
import com.moudy.posts.databinding.ActivityMainBinding
import com.moudy.posts.network.ApiService
import com.moudy.posts.utils.TAGY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity$TAGY"

    private val postAdapter = PostAdapter()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener() {
            val snack = Snackbar.make(it, "This is a simple Snackbar", Snackbar.LENGTH_LONG)
            snack.show()
            val intent = Intent(this@MainActivity, AddPost::class.java)
            startActivity(intent)
        }
        setupPostRecycler()


        // get all posts
        getHome()

        // reconnect
        binding.btnReconnect.setOnClickListener {
            getPosts()
        }
    }

    private fun setupPostRecycler() {
        binding.rvPosts.adapter = postAdapter
        postAdapter.notifyDataSetChanged()
        postAdapter.setOnCLickListener(object : PostAdapter.OnClickListener {
            override fun onClick(post: PostItem) {


                val intent = Intent(this@MainActivity, SingelPost::class.java).apply {
                    putExtra("TITLE", post.title)
                    putExtra("BODY", post.bodyString)


                }
                startActivity(intent)

                Log.d(TAG, "onClick: $post")
                Toast.makeText(this@MainActivity, "${post.id} \n${post.title}", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    private fun getPosts() {
        binding.progress.isVisible = true
        showNoInternetConnection(false)

        ApiService.client.getPosts("https://jsonplaceholder.typicode.com/posts")
            .enqueue(object : Callback<GetAllPosts> {
                override fun onResponse(call: Call<GetAllPosts>, response: Response<GetAllPosts>) {
                    binding.progress.isVisible = false
                    if (response.code() in 200..299) {
                        postAdapter.submitList(response.body())
                    } else {
                        showNoInternetConnection(true)
                        Log.d(TAG, "getPosts() onResponse: Error ${response.code()}")
                        Log.d(
                            TAG,
                            "getPosts() onResponse: Error ${
                                response.errorBody()?.string() ?: "error"
                            }"
                        )
                    }
                }

                override fun onFailure(call: Call<GetAllPosts>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Connection error !", Toast.LENGTH_SHORT)
                        .show()
                    Log.d(TAG, "getPosts() onFailure: ${t.message}")

                    showNoInternetConnection(true)
                }
            }
            )
    }

    private fun showNoInternetConnection(isShow: Boolean) {
        binding.lyNoInternet.isVisible = isShow

    }

    fun getHome() {
        ApiService.client.getHome()

            .enqueue(object : Callback<HomeResponse> {
            override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {
                if (response.code() in 200..299) {
                    Log.d(TAG, "onResponse: success 200")
                } else {
                    Log.d(TAG, "getHome() onResponse: Error ${response.code()}")
                    Log.d(
                        TAG,
                        "getHome() onResponse: Error ${response.errorBody()?.string() ?: "error"}"
                    )
                }
            }

            override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Connection error !", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "getHome() onFailure: ${t.message}")
            }
        })
    }


    /**
     * All posts
    ApiService.client.getPosts().enqueue(object :Callback<GetAllPosts>{
    override fun onResponse(call: Call<GetAllPosts>, response: Response<GetAllPosts>) {
    if (response.code() in 200..299){
    Log.d(TAG, "onResponse: ${response.body()}")
    }
    else{
    Log.d(TAG, "onResponse: Error ${response.code()}")
    Log.d(TAG, "onResponse: Error ${response.errorBody()?.string()?:"error"}")
    }
    }

    override fun onFailure(call: Call<GetAllPosts>, t: Throwable) {
    Toast.makeText(this@MainActivity, "Connection error !", Toast.LENGTH_SHORT).show()
    Log.d(TAG, "onFailure: ${t.message}")
    }
    })

     */

    /**
     * Get single post
    ApiService.client.getSinglePost(1)
    .enqueue(object : Callback<PostItem> {
    override fun onResponse(call: Call<PostItem>, response: Response<PostItem>) {
    if (response.code() in 200..299) {
    Log.d(TAG, "onResponse: ${response.body()}")
    } else {
    Log.d(TAG, "getSinglePost() onResponse: Error ${response.code()}")
    Log.d(
    TAG,
    "getSinglePost() onResponse: Error ${
    response.errorBody()?.string() ?: "error"
    }"
    )
    }
    }

    override fun onFailure(call: Call<PostItem>, t: Throwable) {
    Toast.makeText(this@MainActivity, "Connection error !", Toast.LENGTH_SHORT)
    .show()
    Log.d(TAG, "getSinglePost() onFailure: ${t.message}")
    }
    })
     */
}


