package org.battir.androidtrainingkotlin.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.battir.androidtrainingkotlin.R

class SpinnerCustomAdapter(
    var context: Context,
    var flags: IntArray,
    private var countryNames: Array<String>,
) : BaseAdapter() {
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View
        val vh: ItemHolder
        if (convertView == null) {
            view = inflater.inflate(R.layout.custom_spinner_items, parent, false)
            vh = ItemHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ItemHolder
        }
        vh.label.text = countryNames.get(position)

        val id = context.resources.getIdentifier(flags.get(position).toString(),
            "drawable",
            context.packageName)
        vh.img.setBackgroundResource(id)

        return view
    }

    override fun getItem(position: Int): Any? {
        return countryNames[position];
    }

    override fun getCount(): Int {
        return countryNames.size;
    }

    override fun getItemId(position: Int): Long {
        return position.toLong();
    }

    private class ItemHolder(row: View?) {
        val label: TextView
        val img: ImageView

        init {
            label = row?.findViewById(R.id.textView) as TextView
            img = row?.findViewById(R.id.imageView) as ImageView
        }
    }

}