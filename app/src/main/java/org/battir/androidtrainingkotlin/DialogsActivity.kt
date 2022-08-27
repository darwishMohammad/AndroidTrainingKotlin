package org.battir.androidtrainingkotlin

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import org.battir.androidtrainingkotlin.ui.dialogs.InputDialog
import org.battir.androidtrainingkotlin.ui.dialogs.TimePickerDialog
import java.util.*

class DialogsActivity : AppCompatActivity(), View.OnClickListener , InputDialog.OnInputListener{

    private val tv_name:TextView by lazy {findViewById<TextView>(R.id.tv_name)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialogs)

        findViewById<Button>(R.id.btn_date_dialog).setOnClickListener(this)
        findViewById<Button>(R.id.btn_time_dialog).setOnClickListener(this)
        findViewById<Button>(R.id.btn_simple_dialog).setOnClickListener(this)
        findViewById<Button>(R.id.btn_show_custom_dialog).setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
       when(p0?.id){
           R.id.btn_date_dialog->{
               pickDate()
           }
           R.id.btn_time_dialog->{
               TimePickerDialog().show(supportFragmentManager, "TimeTag")
           }
           R.id.btn_simple_dialog->{
               val builder = AlertDialog.Builder(this)

               with(builder)
               {
                   setTitle("Dialog Title")
                   setMessage("Dialog message")
                   setPositiveButton("OK", DialogInterface.OnClickListener(function = dialogButonsClickListener))
                   setNegativeButton(R.string.cancel, dialogButonsClickListener)
                   setNeutralButton("Maybe", dialogButonsClickListener)
                   //To prevent the user from dismissing without action
                   // setCancelable(false)
                   show()
               }
           }
           R.id.btn_show_custom_dialog->{
//            Create new instance from InputDialog fragment and show it to the user
               InputDialog(this).show(supportFragmentManager, "taglikeID")
           }
       }
    }
        private val dialogButonsClickListener = { dialog: DialogInterface, which: Int ->
        //write your code here
        when(which){
            DialogInterface.BUTTON_POSITIVE ->{
                Toast.makeText(applicationContext,"POSITIVE Button Presses",Toast.LENGTH_LONG).show()
                dialog.dismiss()

            } DialogInterface.BUTTON_NEGATIVE ->{
            Toast.makeText(applicationContext,"NEGATIVE Button Presses",Toast.LENGTH_LONG).show()
            dialog.dismiss()

            } DialogInterface.BUTTON_NEUTRAL ->{
            Toast.makeText(applicationContext,"NEUTRAL Button Presses",Toast.LENGTH_LONG).show()
            dialog.dismiss()

            }
        }
    }
    override fun sendInput(input: String?) {
        tv_name.text=input
    }

    fun processTimePickerResult(hourOfDay: Int, minute: Int) {
        // Convert time elements into strings.
        val hour_string = Integer.toString(hourOfDay)
        val minute_string = Integer.toString(minute)
        // Assign the concatenated strings to timeMessage.
        val timeMessage = "$hour_string:$minute_string"
        (findViewById<View>(R.id.txt_time) as TextView).text = "Time : $timeMessage"
    }
    override fun onBackPressed() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Exit? -Dialog Title-")
        alertDialog.setMessage("Exit the current activity? -Dialog Message-")
        alertDialog.setPositiveButton("Yes") { dialog, which -> finish() }
        alertDialog.setNegativeButton("No") { dialog, which -> dialog.dismiss() }
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
    fun pickDate() {
        val c = Calendar.getInstance()
        val year = c[Calendar.YEAR]
        val month = c[Calendar.MONTH]
        val day = c[Calendar.DAY_OF_MONTH]
        val datePickerDialog: Dialog = DatePickerDialog(this,
            { view, year, month, dayOfMonth -> processDatePickerResult(year, month, dayOfMonth) },
            year,
            month,
            day)
        datePickerDialog.show()
    }
    fun processDatePickerResult(year: Int, month: Int, day: Int) {
        // The month integer returned by the date picker starts counting at 0
        // for January, so you need to add 1 to show months starting at 1.
        val month_string = Integer.toString(month + 1)
        val day_string = Integer.toString(day)
        val year_string = Integer.toString(year)
        // Assign the concatenated strings to dateMessage.
        val dateMessage = "$day_string/$month_string/$year_string"
        (findViewById<View>(R.id.txt_date) as TextView).text = "Date : $dateMessage"
    }
}