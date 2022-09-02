package org.battir.androidtrainingkotlin.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment
import org.battir.androidtrainingkotlin.R


/**
 * A fragment representing a list of Items.
 */
class CitiesFragment : ListFragment() {
    var citiesList = arrayOf(
        "Abu Dis",
        "Bani Na'im",
        "Bani Suheila",
        "Beit Hanoun",
        "Beit Jala",
        "Beit Lahia",
        "Beit Sahour",
        "Beit Ummar",
        "Beitunia",
        "Bethlehem(Beit Lahm)",
        "al-Bireh",
        "Deir al-Balah",
        "ad-Dhahiriya",
        "Dura",
        "Gaza City(Ghazzah)",
        "Halhul",
        "Hebron(al-Khalil)",
        "Idhna",
        "Jabalia",
        "Jenin",
        "Jericho(Ariha)",
        "Khan Yunis",
        "Nablus",
        "Qabatiya",
        "Qalqilya",
        "Rafah",
        "Ramallah",
        "Sa'ir",
        "as-Samu",
        "Surif",
        "Tubas",
        "Tulkarm",
        "Ya'bad",
        "al-Yamun",
        "Yatta"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_countries, container, false)
        val adapter = ArrayAdapter(activity!!,
            android.R.layout.simple_list_item_1, citiesList)
        listAdapter = adapter
        return view
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        Log.i("ListFragmen", citiesList[position])
        val f2: DisplayFragment? =
            parentFragmentManager!!.findFragmentById(R.id.fragment2) as DisplayFragment?
        f2?.change(citiesList[position])
        listView.setSelector(android.R.color.holo_blue_dark)
    }
}