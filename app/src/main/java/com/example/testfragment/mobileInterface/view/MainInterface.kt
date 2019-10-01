package com.example.testfragment.mobileInterface.view

import com.example.testfragment.model.MobileModel

interface MainInterface {
    fun setUpdateData(model: List<MobileModel>)
    fun getSwipeDeleted(mobileModel: MobileModel)


}