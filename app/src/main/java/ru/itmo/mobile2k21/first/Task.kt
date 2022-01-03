package ru.itmo.mobile2k21.first


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.itmo.mobile2k21.R
import ru.itmo.mobile2k21.first.details.DetailsActivity
import ru.itmo.mobile2k21.first.details.DetailsAdapter
import ru.itmo.mobile2k21.first.details.DetailsIcon
import ru.itmo.mobile2k21.first.details.DetailsInfo
import java.io.Serializable

class Task : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val coloredLabel: TextView = findViewById(R.id.first_task__text)
        val changeLabelColorSwitch: Switch = findViewById(R.id.first_task__change_text_color)
        changeLabelColorSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                coloredLabel.setTextColor(R.color.light_grey.toInt())
            } else {
                coloredLabel.setTextColor(R.color.dark_grey.toInt())
            }
        }

        val detailsList = getDetailsList()
        val detailsAdapter = DetailsAdapter(this, detailsList)

        val detailsListView: ListView = findViewById(R.id.details_list_view)
        detailsListView.adapter = detailsAdapter
    }

    private fun getDetailsList(): ArrayList<DetailsInfo> {
        return arrayListOf(
            DetailsInfo(
                "Это заголовок #1",
                "Это очень длинное текстовое описание #1",
                DetailsIcon.rocket
            ),
            DetailsInfo(
                "Это заголовок #2",
                "Это очень длинное текстовое описание #2",
                DetailsIcon.car
            ),
            DetailsInfo(
                "Это заголовок #3",
                "Это очень длинное текстовое описание #3",
                DetailsIcon.atom
            ),
            DetailsInfo(
                "Это заголовок #4",
                "Это очень длинное текстовое описание #4",
                DetailsIcon.guy
            ),
            DetailsInfo(
                "Это заголовок #5",
                "Это очень длинное текстовое описание #5",
                DetailsIcon.rocket
            )
        )
    }
}