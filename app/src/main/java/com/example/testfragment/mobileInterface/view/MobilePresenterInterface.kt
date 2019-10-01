package com.example.testfragment.mobileInterface.view

import com.example.testfragment.model.MobileModel


interface MobilePresenterInterface : BaseView {
    fun setMobile(mobileModelList: List<MobileModel>)
    fun setMobileSecond(mobileModelList: List<MobileModel>)
}