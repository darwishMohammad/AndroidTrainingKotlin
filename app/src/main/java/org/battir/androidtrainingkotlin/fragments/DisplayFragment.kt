package org.battir.androidtrainingkotlin.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.battir.androidtrainingkotlin.R


class DisplayFragment : Fragment() {
    var tv_selectedCity: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_display, container, false)
        tv_selectedCity = view.findViewById<TextView>(R.id.tv_cityname) as TextView
        return view
    }

    fun change(txt: String?) {
        Log.i("change called",txt.toString())
        tv_selectedCity?.setText(txt)
    }
}