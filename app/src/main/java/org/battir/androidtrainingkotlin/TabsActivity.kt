package org.battir.androidtrainingkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import org.battir.androidtrainingkotlin.Adapters.ViewPagerAdapter
import org.battir.androidtrainingkotlin.fragments.Tab1Fragment
import org.battir.androidtrainingkotlin.fragments.Tab2Fragment

class TabsActivity : AppCompatActivity() {

    private lateinit var pager: ViewPager // creating object of ViewPager
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
    val adapter = ViewPagerAdapter(supportFragmentManager)

    // add fragment to the list
    adapter.addFragment(Tab1Fragment(), "Tab 1")
    adapter.addFragment(Tab2Fragment(), "Tab 2")

    // Adding the Adapter to the ViewPager
    pager.adapter = adapter

    // bind the viewPager with the TabLayout.
    tab.setupWithViewPager(pager)
}
}