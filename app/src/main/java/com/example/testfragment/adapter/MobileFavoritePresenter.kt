package com.example.testfragment.adapter

import com.example.testfragment.MyCustomSharedPreference
import com.example.testfragment.mobile_interface.MobileFavoritePresenterInterface
import com.example.testfragment.model.MobileFavoriteModel
import com.google.gson.GsonBuilder


class MobileFavoritePresenter(val view: MobileFavoritePresenterInterface, val sharedPref: MyCustomSharedPreference) {
    private var gson = GsonBuilder().create()

    fun getMobileFavorite() {
        val str = sharedPref.getModelArrayList("TEST")
        if (str != null) {
            gson.fromJson(str, Array<MobileFavoriteModel>::class.java).toList()
                ?.apply {
                    if (this.isNotEmpty()) {
//                        view.setMobile(this,model)
                        view.setMobile(this)
                    }
                }

        }
    }
}