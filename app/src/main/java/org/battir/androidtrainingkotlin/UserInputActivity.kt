package org.battir.androidtrainingkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class UserInputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_input)
        findViewById<Button>(R.id.btn_ok).setOnClickListener{
            var bundle: Bundle=Bundle()
            bundle.putCharSequence("Name",findViewById<EditText>(R.id.editTextTextPersonName).text)
            setResult(RESULT_OK, Intent().putExtras(bundle))
            finish()
        }
    }
}