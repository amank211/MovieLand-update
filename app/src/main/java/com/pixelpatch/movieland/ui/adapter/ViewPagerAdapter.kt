package com.pixelpatch.movieland.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

internal class ViewPagerAdapter(manager: FragmentManager?) :
    FragmentPagerAdapter(manager!!) {
    private val fragmentList: MutableList<Fragment> = ArrayList()
    private val fragmentTitle: MutableList<String> = ArrayList()
    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    fun addFrag(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitle.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitle[position]
    }
}