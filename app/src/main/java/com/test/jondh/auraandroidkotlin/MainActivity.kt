package com.test.jondh.auraandroidkotlin

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.bumptech.glide.Glide
import com.test.jondh.auraandroidkotlin.network.APIHelper
import com.test.jondh.auraandroidkotlin.network.PicsumInfo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val iv = findViewById<ImageView>(R.id.image_view)

        APIHelper.getInstance(this)
            .getImageInfo("0",
                Response.Listener<PicsumInfo> { response ->
                    Glide.with(this).load(response.getDownloadUrl()).into(iv)
                },
                Response.ErrorListener { error ->
                    Log.d("!!", "MainActivity onResponse1 - " + error.message)
                    Toast.makeText(this@MainActivity, "Error!1!!", Toast.LENGTH_LONG).show()
                })
    }
}