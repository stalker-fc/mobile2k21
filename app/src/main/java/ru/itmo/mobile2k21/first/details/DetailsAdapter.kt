package ru.itmo.mobile2k21.first.details

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat.startActivity
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
            val info = getItem(position)
            view.setOnClickListener {
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra(FieldNames.detailScreenInfo, info as Serializable)
                startActivity(context, intent, null)
            }
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

}