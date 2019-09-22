package com.example.testfragment.ui.main.main.main

import com.example.testfragment.MainActivity
import com.example.testfragment.fragment.FavoriteListFragment
import com.example.testfragment.fragment.MobileListFragment
import com.example.testfragment.model.FragmentModel

class FragmentPresenter(private val view: FragmentInterface) {

    fun getFragment() {
        val tabList = listOf(
            FragmentModel(MainActivity.LIST_MOBILE_TAB_NAME, MobileListFragment.newInstance()),
            FragmentModel(MainActivity.FAVORITE_LIST_TAB_NAME, FavoriteListFragment.newInstance())
        )

        view.setFragment(tabList)
    }


}