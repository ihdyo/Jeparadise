package com.example.jeparadise.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.jeparadise.R
import com.example.jeparadise.databinding.ActivityDetailBinding
import com.example.jeparadise.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val Name = intent.getStringExtra("name")
        val Url = intent.getStringExtra("url")
        val Location = intent.getStringExtra("location")
        val Distance = intent.getStringExtra("distance")
        val Description = intent.getStringExtra("description")
        val Category = intent.getStringExtra("category")

        Picasso.get().load(Url).into(image)
        name.text = Name
        location.text = Location
        distance.text = Distance
        description.text = Description
        category.text = Category
    }
}