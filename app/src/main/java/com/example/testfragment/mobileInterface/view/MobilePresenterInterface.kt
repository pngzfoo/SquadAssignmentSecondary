package com.example.testfragment.mobileInterface.view

import com.example.testfragment.model.MobileModel
import com.example.testfragment.presenter.BaseView


interface MobilePresenterInterface : BaseView {
    fun setMobile(mobileModelList: List<MobileModel>)
    fun setMobileSecond(mobileModelList: List<MobileModel>)
}