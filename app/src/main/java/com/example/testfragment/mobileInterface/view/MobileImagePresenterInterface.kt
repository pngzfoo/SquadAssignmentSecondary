package com.example.testfragment.mobileInterface.view

import com.example.testfragment.model.MobileImageModel


interface MobileImagePresenterInterface : BaseView {
    fun setImage(mobileModelList: List<MobileImageModel>)
}