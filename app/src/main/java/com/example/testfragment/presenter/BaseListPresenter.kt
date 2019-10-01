package com.example.testfragment.presenter

import android.view.View
import com.example.testfragment.model.MobileModel


abstract class BaseListPresenter : BasePresenter() {

    private var view: View? = null

    fun setView(view: View?) {
        this.view = view
    }

    fun sortPrice(dataMobileFavList: List<MobileModel>): List<MobileModel> {
        return dataMobileFavList.sortedBy { it.price }
    }

    fun sortReversePrice(dataMobileFavList: List<MobileModel>): List<MobileModel> {
        return dataMobileFavList.sortedByDescending { it.price }
    }


    fun sortRating(dataMobileFavList: List<MobileModel>): List<MobileModel> {
        return dataMobileFavList.sortedBy { it.rating }
    }


}