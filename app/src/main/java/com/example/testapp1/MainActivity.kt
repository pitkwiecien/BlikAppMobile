package com.example.testapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
                binding.textView.text = "31321"
        }

    }
    fun getDataFromApi(fromUrl: String) {
    
    }
}