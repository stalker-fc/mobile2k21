package ru.itmo.mobile2k21
import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

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

        val coloredLabel: TextView = findViewById(R.id.colored_label)
        val changeLabelColorSwitch: Switch = findViewById(R.id.change_label_color_switch)
        changeLabelColorSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                coloredLabel.setTextColor(Color.RED)
            } else {
                coloredLabel.setTextColor(Color.BLUE)
            }
        }


        }

    }
