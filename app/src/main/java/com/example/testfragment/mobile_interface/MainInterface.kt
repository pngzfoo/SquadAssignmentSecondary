package com.example.testfragment.mobile_interface

import com.example.testfragment.model.MobileModel

interface MainInterface {
    fun setUpdateData(model: List<MobileModel>)
    fun getSwipeDeleted(mobileModel: MobileModel)

}