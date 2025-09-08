package com.travelblog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.travelblog.databinding.ActivityLoginBinding
import com.travelblog.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}