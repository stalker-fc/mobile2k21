package ru.itmo.mobile2k21.first


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import ru.itmo.mobile2k21.R
import ru.itmo.mobile2k21.first.details.DetailsAdapter
import ru.itmo.mobile2k21.first.details.DetailsIcon
import ru.itmo.mobile2k21.first.details.DetailsInfo

class Task : AppCompatActivity() {
    private var isListVisible: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val coloredLabel: TextView = findViewById(R.id.colored_text)
        val changeLabelColorSwitch: SwitchCompat = findViewById(R.id.change_text_color_switch)
        changeLabelColorSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                coloredLabel.setTextColor(getColor(R.color.light_grey))
            } else {
                coloredLabel.setTextColor(getColor(R.color.dark_grey))
            }
        }


        val detailsListView: ListView = findViewById(R.id.details_list_view)
        val listVisibilityButton: Button = findViewById(R.id.list_visibility_button)
        listVisibilityButton.setOnClickListener {
            isListVisible = !isListVisible
            if (isListVisible) {
                detailsListView.visibility = View.VISIBLE
                listVisibilityButton.text = getString(R.string.hide_list)
            } else {
                detailsListView.visibility = View.INVISIBLE
                listVisibilityButton.text = getString(R.string.show_list)
            }

        }

        val toastButton: Button = findViewById(R.id.toast_button)
        toastButton.setOnClickListener {
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, R.string.toast_text, duration)
            toast.show()
        }

        val detailsList = getDetailsList()
        val detailsAdapter = DetailsAdapter(this, detailsList)
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