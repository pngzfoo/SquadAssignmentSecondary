package com.example.testfragment.ui.main

import com.example.testfragment.model.MobileModel


class Sort(i: Int) {

    var int: Int = i

    fun sortBy(mobileModelList: List<MobileModel>) :List<MobileModel> {

        return when (int) {
            1 -> return mobileModelList.sortedBy { it.price }
            2 -> return mobileModelList.sortedByDescending { it.price }
            3 -> return mobileModelList.sortedBy { it.rating }

            else -> return mobileModelList
        }

    }
}