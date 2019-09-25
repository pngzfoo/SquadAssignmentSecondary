package com.example.testfragment.mobile_interface

import com.example.testfragment.model.MobileModel

interface MobileItemClickListener {

    fun onItemClick(mobileModel: MobileModel)
    fun onHeartClick(mobileModel: MobileModel)//

}