package com.travelblog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.travelblog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainTextView.text = "Hello MyTrucking"
    }
}