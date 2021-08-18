package com.example.assisnment_mvvm_and_coroutines.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assisnment_mvvm_and_coroutines.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_full_screen_image.*

class FullScreenImage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_image)

        val url = intent?.getStringExtra("url")
        Picasso.get().load(url).into(image)
    }
}