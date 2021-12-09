package ru.itmo.mobile2k21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toFirstTaskButton: Button = findViewById(R.id.to_first_task)
        toFirstTaskButton.setOnClickListener(View.OnClickListener { view ->
            val value = arrayListOf<String>("one", "two", "one")

            val intent = Intent(this@MainActivity, FirstActivity::class.java)
            intent.putStringArrayListExtra(FieldNames.superValue, value)
            startActivity(intent)
        })

        val toastButton: Button = findViewById(R.id.toast_button)
        toastButton.setOnClickListener(View.OnClickListener { view ->
            Toast.makeText(this@MainActivity, "Its toast!", Toast.LENGTH_SHORT).show()
        })

        val logButton: Button = findViewById(R.id.log_button)
        logButton.setOnClickListener(View.OnClickListener { view ->
            Log.i("MainActivity", "Log-button works!")
        })
    }
}