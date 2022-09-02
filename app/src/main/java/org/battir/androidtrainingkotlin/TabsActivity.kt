package org.battir.androidtrainingkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.battir.androidtrainingkotlin.Adapters.ViewPagerAdapter
import org.battir.androidtrainingkotlin.fragments.Tab1Fragment
import org.battir.androidtrainingkotlin.fragments.Tab2Fragment

class TabsActivity : AppCompatActivity() {

    private lateinit var pager: ViewPager2 // creating object of ViewPager
    private lateinit var tab: TabLayout  // creating object of TabLayout
    private lateinit var bar: Toolbar    // creating object of ToolBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)

        // set the references of the declared objects above
        pager = findViewById(R.id.viewPager)
        tab = findViewById(R.id.tabs)
        bar = findViewById(R.id.toolbar)

        // To make our toolbar show the application
        // we need to give it to the ActionBar
        setSupportActionBar(bar)

        // Initializing the ViewPagerAdapter
        val adapter = ViewPagerAdapter(this)

        // add fragment to the list
        adapter.addFragment(Tab1Fragment())
        adapter.addFragment(Tab2Fragment())

        pager.adapter = adapter
        // Adding the Adapter to the ViewPager


        // bind the viewPager with the TabLayout.
        // tab.setupWithViewPager(pager)
        TabLayoutMediator(tab, pager) { tab, position ->
            tab.text = if (position == 0) "Tab 1" else "Tab 2"
        }.attach()
    }
}