package com.example.mvvmlist.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.mvvmlist.R
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val text: TextView = findViewById(R.id.textView)
        val image: ImageView = findViewById(R.id.imageView)
        text.text = intent.getStringExtra("title")
        Picasso.get().load(intent.getStringExtra("img")).into(image)
    }
}