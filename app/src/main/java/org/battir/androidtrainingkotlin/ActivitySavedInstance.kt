package org.battir.androidtrainingkotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivitySavedInstance : AppCompatActivity() {
    lateinit var txt_counter: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_instance)
        txt_counter = findViewById(R.id.txt_counter)
        findViewById<Button>(R.id.btn_count).setOnClickListener {
            var count = txt_counter.text.toString().toInt()
            txt_counter.text = "".plus(++count)
        }

        /* You can restore the saved instance in onCreate function and also in
            RestoreInstanceState
            */
//        if (savedInstanceState != null) {
//            val count = savedInstanceState.getString("count")
//            if (txt_counter != null) txt_counter.setText(count)
//        }

    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume ")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart ")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("count", txt_counter.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        txt_counter.text = savedInstanceState.getString("count")
    }

    companion object {
        private const val TAG = "ActivitySavedInstance"
    }
}