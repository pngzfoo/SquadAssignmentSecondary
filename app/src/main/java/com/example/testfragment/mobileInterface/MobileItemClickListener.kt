package com.example.testfragment.mobileInterface

import com.example.testfragment.model.MobileModel

interface MobileItemClickListener {
    fun onItemClick(mobileModel: MobileModel)
    fun onHeartClick(mobileModel: List<MobileModel>)
}