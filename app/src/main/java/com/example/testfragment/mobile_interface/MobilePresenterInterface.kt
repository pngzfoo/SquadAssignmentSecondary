package com.example.testfragment.mobile_interface

import com.example.testfragment.model.MobileModel


interface MobilePresenterInterface {
    fun setMobile(mobileModelList: List<MobileModel>)
    fun setMobileSecond(mobileModelList: List<MobileModel>)
}