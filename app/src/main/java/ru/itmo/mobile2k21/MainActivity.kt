package ru.itmo.mobile2k21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import ru.itmo.mobile2k21.first.FieldNames
import ru.itmo.mobile2k21.first.FirstActivity
import ru.itmo.mobile2k21.second.SecondActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toFirstTaskButton: Button = findViewById(R.id.to_first_task)
        toFirstTaskButton.setOnClickListener(View.OnClickListener {
            val value = arrayListOf<String>("one", "two", "one")

            val intent = Intent(this@MainActivity, FirstActivity::class.java)
            intent.putStringArrayListExtra(FieldNames.superValue, value)
            startActivity(intent)
        })

        val toSecondTaskButton: Button = findViewById(R.id.to_second_task)
        toSecondTaskButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        })

        val logButton: Button = findViewById(R.id.log_button)
        logButton.setOnClickListener(View.OnClickListener {
            Log.i("MainActivity", "Log-button works!")
        })
    }
}