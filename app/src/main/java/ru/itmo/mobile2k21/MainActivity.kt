package ru.itmo.mobile2k21

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ru.itmo.mobile2k21.first.FirstActivity
import ru.itmo.mobile2k21.second.SecondActivity
import ru.itmo.mobile2k21.third.ThirdActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toFirstTaskButton: Button = findViewById(R.id.to_first_task)
        toFirstTaskButton.setOnClickListener {
            val intent = Intent(this@MainActivity, FirstActivity::class.java)
            startActivity(intent)
        }

        val toSecondTaskButton: Button = findViewById(R.id.to_second_task)
        toSecondTaskButton.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }

        val toThirdTaskButton: Button = findViewById(R.id.to_third_task)
        toThirdTaskButton.setOnClickListener {
            val intent = Intent(this@MainActivity, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}