package com.example.testapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.testapp1.databinding.ActivityPotwierdzanieBinding

class Potwierdzanie : AppCompatActivity() {
    lateinit var binding: ActivityPotwierdzanieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_potwierdzanie)

        binding = ActivityPotwierdzanieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener{
            binding.textView2.text = "20.0zł"
        }
    }
}