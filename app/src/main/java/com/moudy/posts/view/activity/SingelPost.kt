package com.moudy.posts.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import com.moudy.posts.R
import com.moudy.posts.databinding.ActivityMainBinding
import com.moudy.posts.databinding.ActivitySingelPostBinding

class SingelPost : AppCompatActivity() {
    private lateinit var binding: ActivitySingelPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingelPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title_message = intent.getStringExtra("TITLE")
        val body_message = intent.getStringExtra("BODY")

        binding.titleTV.text=title_message
        binding.bodyTV.text=body_message

    }
}