package org.battir.androidtrainingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ReceiveIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive_intent)

        val message = intent.getStringExtra(EXTRA_MESSAGE)


        findViewById<TextView>(R.id.tv_extraholder).text=message
    }
}