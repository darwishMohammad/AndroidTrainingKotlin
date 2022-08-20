package org.battir.androidtrainingkotlin

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class FragmentHostActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frament)
    }
}