package com.example.testfragment.mobile_interface

import com.example.testfragment.model.MobileModel

interface FavoriteItemClickListener {

    fun onItemClick(mobileModel: MobileModel)
    fun onSwipeDelete(deletedModel: MobileModel)

}