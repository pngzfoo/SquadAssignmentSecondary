package com.example.testfragment.mobileInterface.view

import com.example.testfragment.model.MobileModel

interface MobileFavoritePresenterInterface {

    fun setMobile(mobileFavModelList: List<MobileModel>)
    fun setMobileSecondary(mobileFavModelList: List<MobileModel>, checkedItem: Int)
    fun setMobileThird(mobileFavModelList: List<MobileModel>)


}