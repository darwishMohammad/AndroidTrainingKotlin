package org.battir.androidtrainingkotlin

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.snackbar.Snackbar
import org.battir.androidtrainingkotlin.Adapters.SpinnerCustomAdapter


class ViewsActivity : AppCompatActivity() {
    lateinit var radioGroup: RadioGroup
    var spinner: Spinner? = null
    var countryNames = arrayOf<String>("India", "China", "Australia", "Portugle", "America", "New Zealand")
    var flags = intArrayOf(R.drawable.bar_chart,
        R.drawable.emp_pic3,
        R.drawable.ic_job_running,
        R.drawable.ic_user_icon,
        R.drawable.rounded_butoon,
        R.drawable.ic_user_icon)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views)

        /**
         * Radio Buttons and Radiobutton Group
         */
        radioGroup = findViewById<View>(R.id.rg_gender) as RadioGroup
        radioGroup!!.setOnCheckedChangeListener { radioGroup, checkedId ->
            when (checkedId) {
                R.id.rb_1 ->{
                    Toast.makeText(applicationContext, "Index 1", Toast.LENGTH_LONG).show()
                }
                R.id.rb_2 -> Toast.makeText(applicationContext, "Index 2", Toast.LENGTH_LONG).show()
            }
        }
        /**
         * Spinner With Array of String
         */
        spinner = findViewById<Spinner>(R.id.spinner)
        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
                Toast.makeText(applicationContext,
                    "You select " + (view as TextView).text.toString(),
                    Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }
        /**
         * Spinner with custom adapter
         */
        val spin = findViewById<View>(R.id.spinner_custom) as Spinner
        val customAdapter = SpinnerCustomAdapter(this, flags, countryNames)
        spin.adapter = customAdapter

        //When activity starts, this view gain the focus
        /**
         * EditText focus listener
         */
        val editText1 = findViewById<EditText>(R.id.editText)
        editText1.requestFocus()
        editText1.setOnFocusChangeListener(View.OnFocusChangeListener { view, b ->
            if (b == true) {
                var edt:EditText =view as EditText
                edt.setTextColor(Color.RED)
                Toast.makeText(this, "Focus Loast", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Focus gained", Toast.LENGTH_LONG).show()
                var edt:EditText =view as EditText
                edt.setTextColor(Color.BLACK)
            }
        })

        /**
         * Floating Action Button
         */
        findViewById<ExtendedFloatingActionButton>(R.id.fab_extended).setOnClickListener { view ->
            val snackbar = Snackbar
                .make(view, "Are you sure you want to clos this window?", Snackbar.LENGTH_LONG)
                .setAction("Okay") {
                    finish()
                }
            snackbar.setActionTextColor(Color.RED)
            snackbar.setTextColor(Color.YELLOW)
            snackbar.show()
        }
    }

    fun showToastOfText(view: View) {
        val on = (view as ToggleButton).isChecked
        if (on) {
            Toast.makeText(this,
                "Button is On and text is :" + view.text.toString(),
                Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this,
                "Button is Off and text is :" + view.text.toString(),
                Toast.LENGTH_LONG).show()
        }
    }
}