package com.example.testapp1

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
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
        val url = URL("http://192.168.1.137:8080/api/blik                             ")
        val connection = url.openConnection()
        BufferedReader(InputStreamReader(connection.getInputStream())).use { inp ->
            var line: String?
            while (inp.readLine().also { line = it } != null) {
                println(line)
            }
        }
    }
    fun getDataFromApi(fromUrl: String) {
        val url = "http://www.omdbapi.com/?t=&apikey=cebd9b53"
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                if (response.get("Response") == "False") {
                    binding.textView.text = "Incorrect detail"
                } else {
                    binding.textView.text =
                        response.getString("Title") + "\n\n" + "Writer: " + response.getString("Writer")
                }
            },
            { error ->
                Log.d("vol", error.toString())
            }
        )

    }
}