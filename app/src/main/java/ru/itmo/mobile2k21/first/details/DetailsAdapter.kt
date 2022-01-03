package ru.itmo.mobile2k21.first.details

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import ru.itmo.mobile2k21.R
import ru.itmo.mobile2k21.first.FieldNames
import java.io.Serializable


class DetailsAdapter(
    private val context: Context,
    private val details: ArrayList<DetailsInfo>
): BaseAdapter() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return details.size
    }

    override fun getItem(position: Int): DetailsInfo {
        return details[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val vh: DetailsRowHolder
        if (convertView == null) {
            view = this.inflater.inflate(R.layout.row_details, parent, false)
            vh = DetailsRowHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as DetailsRowHolder
        }

        vh.title.text = details[position].title
        vh.description.text = details[position].description
        return view
    }

//    private fun kek() {
//        val toDetailScreenActivity: Button = findViewById(R.id.to_detail_screen)
//        toDetailScreenActivity.setOnClickListener(View.OnClickListener {
//            val intent = Intent(this@Task, DetailsActivity::class.java)
//            val info = DetailsInfo(
//                "Это подпись",
//                "Это очень длинное текстовое описание",
//                DetailsIcon.guy
//            )
//            intent.putExtra(FieldNames.detailScreenInfo, info as Serializable)
//            startActivity(intent)
//        })
//
//    }

}