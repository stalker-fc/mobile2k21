package ru.itmo.mobile2k21.third.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import ru.itmo.mobile2k21.R
import ru.itmo.mobile2k21.third.CatsClient

class Task : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val catImage: ImageView = findViewById(R.id.cat_image)

        val catsClient = CatsClient(catImage)
        val loadCatButton: Button = findViewById(R.id.load_cat_button)
        loadCatButton.setOnClickListener{
            catsClient.getRandomCat()
        }

    }
}