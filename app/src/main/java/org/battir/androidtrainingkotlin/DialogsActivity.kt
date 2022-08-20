package org.battir.androidtrainingkotlin

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import org.battir.androidtrainingkotlin.ui.dialogs.InputDialog

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
           R.id.btn_date_dialog->{}
           R.id.btn_time_dialog->{}
           R.id.btn_simple_dialog->{
               val builder = AlertDialog.Builder(this)

               with(builder)
               {
                   setTitle("Androidly Alert")
                   setMessage("This is the message")
                   setPositiveButton("OK", DialogInterface.OnClickListener(function = dialogButonsClickListener))
                   setNegativeButton(R.string.cancel, dialogButonsClickListener)
                   setNeutralButton("Maybe", dialogButonsClickListener)
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
}