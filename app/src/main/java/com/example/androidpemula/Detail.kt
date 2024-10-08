package com.example.androidpemula

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class Detail : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }


        val titleTextView: TextView = findViewById(R.id.text_title)
        val imageNews: ImageView = findViewById(R.id.titleImg)
        val descNews: TextView = findViewById(R.id.text_description)


        val bundle: Bundle? = intent.extras
        bundle?.let {
            val title = it.getString("text_title")
            val imageResId = it.getInt("titleImg")
            val description = it.getString("text_description")

            titleTextView.text = title
            imageNews.setImageResource(imageResId)
            descNews.text = description
        }
    }
}