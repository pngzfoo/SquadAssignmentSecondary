package com.example.testfragment.adapter

import com.example.testfragment.MyCustomSharedPreference
import com.example.testfragment.mobile_interface.MobileFavoritePresenterInterface
import com.example.testfragment.model.MobileModel
import com.google.gson.GsonBuilder


class MobileFavoritePresenter(val view: MobileFavoritePresenterInterface) {
    private var gson = GsonBuilder().create()

    fun getMobileFavorite(sharedPref: MyCustomSharedPreference) {
        val str = sharedPref.getModelArrayList("TEST")
        if (str != null) {
            view.setMobile(str)
        }
    }


    fun sortPrice(dataMobileFavList: List<MobileModel>): List<MobileModel> {
        if (dataMobileFavList.isNotEmpty()) {
            return dataMobileFavList.sortedBy { it.price }
        }
        return listOf()

    }


    fun sortReversePrice(dataMobileFavList: List<MobileModel>): List<MobileModel> {
        if (dataMobileFavList.isNotEmpty()) {
            return dataMobileFavList.sortedByDescending { it.price }
        }
        return listOf()
    }


    fun sortRating(dataMobileFavList: List<MobileModel>): List<MobileModel> {
        if (dataMobileFavList.isNotEmpty()) {
            return dataMobileFavList.sortedBy { it.rating }
        }
        return listOf()
    }


}