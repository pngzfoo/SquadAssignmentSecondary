package com.example.testfragment.ui.main.main.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.testfragment.model.FragmentModel

class IntroPagerAdapter(
    private val fmList: List<FragmentModel>,
    fm: FragmentManager
) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return fmList[position].fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fmList[position].tabName
    }

    override fun getCount(): Int {
        return fmList.count()
    }
}