package com.example.testfragment.ui.main.main.main

import com.example.testfragment.MainActivity
import com.example.testfragment.fragment.FavoriteListFragment
import com.example.testfragment.fragment.MobileListFragment
import com.example.testfragment.model.FragmentModel

class FragmentPresenter(private val view: FragmentInterface) {

    fun getFragment(int: Int) {
        val tabList = listOf(
            FragmentModel(MainActivity.LIST_MOBILE_TAB_NAME, MobileListFragment.newInstance(int)),
                FragmentModel(MainActivity.FAVORITE_LIST_TAB_NAME, FavoriteListFragment.newInstance(int))
        )

        view.setFragment(tabList)
    }


}