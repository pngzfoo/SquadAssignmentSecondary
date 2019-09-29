package com.example.testfragment.mobile_interface

import com.example.testfragment.model.MobileModel


interface MobilePresenterInterface {

    fun setMobile(mobileModelList: List<MobileModel>)
    fun setTestMobile(mobileModelList: List<MobileModel>)
    fun setMobileThird(mobileModelList: List<MobileModel>, checkedId: Int)

}