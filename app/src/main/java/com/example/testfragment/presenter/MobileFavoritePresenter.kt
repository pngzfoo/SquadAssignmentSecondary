package com.example.testfragment.presenter

import com.example.testfragment.mobileInterface.view.MobileFavoritePresenterInterface


class MobileFavoritePresenter(val view: MobileFavoritePresenterInterface) : BaseListPresenter() {

    fun getMobileFavorite(sharedPref: MyCustomSharedPreference) {
        val str = sharedPref.getModelArrayList("TEST")
        view.setMobile(str)

    }




}