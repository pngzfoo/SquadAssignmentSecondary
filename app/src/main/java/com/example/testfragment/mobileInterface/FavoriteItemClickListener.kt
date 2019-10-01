package com.example.testfragment.mobileInterface

import com.example.testfragment.model.MobileModel

interface FavoriteItemClickListener {

    fun onItemClick(mobileModel: MobileModel)
    fun onSwipeDelete(deletedModel: MobileModel)

}