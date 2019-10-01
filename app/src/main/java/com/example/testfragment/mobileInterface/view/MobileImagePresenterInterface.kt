package com.example.testfragment.mobileInterface.view

import com.example.testfragment.model.MobileImageModel
import com.example.testfragment.presenter.BaseView


interface MobileImagePresenterInterface : BaseView {
    fun setImage(mobileModelList: List<MobileImageModel>)
}