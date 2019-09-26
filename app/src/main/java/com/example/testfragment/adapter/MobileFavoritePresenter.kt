package com.example.testfragment.adapter

import com.example.testfragment.MyCustomSharedPreference
import com.example.testfragment.mobile_interface.MobileFavoritePresenterInterface
import com.google.gson.GsonBuilder


class MobileFavoritePresenter(val view: MobileFavoritePresenterInterface, val sharedPref: MyCustomSharedPreference) {
    private var gson = GsonBuilder().create()

    fun getMobileFavorite() {
        val str = sharedPref.getModelArrayList("TEST")
        if (str != null) {
            view.setMobile(str)
        }
    }
}