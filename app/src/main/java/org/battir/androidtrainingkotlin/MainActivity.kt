package org.battir.androidtrainingkotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_hel=findViewById<Button>(R.id.btn_ShowToast)

        val edt_name=findViewById<EditText>(R.id.edt_urname)

//        btn_hel.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(view: View?) {
//                Toast.makeText(this@MainActivity, "Hello ${edt_name.text}", Toast.LENGTH_LONG).show()
//            }
//        })

        btn_hel.setOnClickListener{
            Toast.makeText(this@MainActivity, "Hello ${edt_name.text}", Toast.LENGTH_SHORT).show()
        }

//        btn_hel.setOnClickListener(View.OnClickListener { view ->
//            Toast.makeText(this@MainActivity, "Hello ${edt_name.text}", Toast.LENGTH_SHORT).show()
//        })


    }
}