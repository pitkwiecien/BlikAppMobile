package com.example.testapp1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.RetryPolicy
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.testapp1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val url = "http://192.168.1.109:8080/api/blik/"
        val queue = Volley.newRequestQueue(this)
// prepare the Request

// prepare the Request
        val getRequest = object : JsonObjectRequest(
            Request.Method.POST, url, null,
            Response.Listener { response ->
                // display response
                Log.d("Response", response.toString())
                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
            },
            Response.ErrorListener { error ->
                Log.d("Error.Response", error.toString())
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
            }
        ) {
            // add a header
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["access-token"] = "r392jnfv2-almf92nww1-ld:fwfa"
                return headers
            }
        }



// add it to the RequestQueue

        binding.button.setOnClickListener{
                binding.textView.text = "31321"
            queue.add(getRequest)
         //   getDataFromApi("http://192.168.1.108:8080/api/blik/")
        }
    /*
        val url = URL("http://192.168.1.108:8080/api/blik/")
        val headerName = "access-token"
        val headerValue = "r392jnfv2-almf92nww1-ld:fwfa"
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.setRequestProperty(headerName,headerValue)
        val responseCode = connection.responseCode
        println("Response code: $responseCode")
    */


       /*
        BufferedReader(InputStreamReader(connection.getInputStream())).use { inp ->
            var line: String?
            while (inp.readLine().also { line = it } != null) {
                println(line)
            }
        }
        */

    }
    /*
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

     */
}