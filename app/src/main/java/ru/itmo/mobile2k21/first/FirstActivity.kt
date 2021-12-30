package ru.itmo.mobile2k21.first

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import ru.itmo.mobile2k21.R

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_first)
        val value = intent.getStringArrayListExtra(FieldNames.superValue)
        if (value != null) {
            Log.i("FirstActivity", value.toString())
        } else {
            Log.i("FirstActivity", "Problems")
        }

        val coloredLabel: TextView = findViewById(R.id.first_task__text)
        val changeLabelColorSwitch: Switch = findViewById(R.id.first_task__change_text_color)
        changeLabelColorSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                coloredLabel.setTextColor(R.color.light_grey.toInt())
            } else {
                coloredLabel.setTextColor(R.color.dark_grey.toInt())
            }
        }

        val toDetailScreenActivity: Button = findViewById(R.id.to_detail_screen)
        toDetailScreenActivity.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@FirstActivity, DetailScreenActivity::class.java)
            startActivity(intent)
        })
    }
}