package ru.itmo.mobile2k21.first


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.itmo.mobile2k21.R
import java.io.Serializable

class Task : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val detailsList = getDetailsList()

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
            val intent = Intent(this@Task, DetailsActivity::class.java)
            val info = DetailsInfo(
                "Это подпись",
                "Это очень длинное текстовое описание",
                DetailsIcon.guy
            )
            intent.putExtra(FieldNames.detailScreenInfo, info as Serializable)
            startActivity(intent)
        })
    }

    private fun getDetailsList(): List<DetailsInfo> {
        val detailsList: List<DetailsInfo> = listOf(
            DetailsInfo(
                "Это подпись #1",
                "Это очень длинное текстовое описание #1",
                DetailsIcon.rocket
            ),
            DetailsInfo(
                "Это подпись #2",
                "Это очень длинное текстовое описание #2",
                DetailsIcon.car
            ),
            DetailsInfo(
                "Это подпись #3",
                "Это очень длинное текстовое описание #3",
                DetailsIcon.atom
            ),
            DetailsInfo(
                "Это подпись #4",
                "Это очень длинное текстовое описание #4",
                DetailsIcon.guy
            )
        )
        return detailsList
    }
}