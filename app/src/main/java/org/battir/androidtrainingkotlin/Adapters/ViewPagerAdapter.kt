package org.battir.androidtrainingkotlin.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    // declare arrayList to contain fragments and its title
    private val mFragmentList = ArrayList<Fragment>()

    fun addFragment(fragment: Fragment ){
        // add each fragment and its title to the array list
        mFragmentList.add(fragment)
    }
    override fun getItemCount(): Int {
        return mFragmentList.size
    }
    override fun createFragment(position: Int): Fragment {
        return mFragmentList.get(position)
    }
}