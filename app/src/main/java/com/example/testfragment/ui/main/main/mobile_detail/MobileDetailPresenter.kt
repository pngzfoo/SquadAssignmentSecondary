package com.example.testfragment.ui.main.main.mobile_detail

import com.example.testfragment.model.MobileModel


class MobileDetailPresenter(private val view: MobileDetailInterface) {

    fun checkMobile(mobileItem: MobileModel) {
        view.setMobile(

            mobileItem.name ?: "",
            mobileItem.brand ?: "",
            mobileItem.description ?:"",
            mobileItem.price ?: "",
             mobileItem.thumbImageURL
        )
    }

}

