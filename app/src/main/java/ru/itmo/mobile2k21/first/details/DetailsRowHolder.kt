package ru.itmo.mobile2k21.first.details

import android.view.View
import android.widget.TextView
import ru.itmo.mobile2k21.R

class DetailsRowHolder(row: View) {
    val title: TextView = row.findViewById(R.id.details_row_title)
    val description: TextView = row.findViewById(R.id.details_row_description)
}
