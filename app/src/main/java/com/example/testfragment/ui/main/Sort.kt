package com.example.testfragment.ui.main

import com.example.testfragment.model.MobileModel


class Sort(i: Int) {

    var int: Int = i

    fun sortBy(mobileModelList: List<MobileModel>) :List<MobileModel> {

        return when (int) {
            0 -> mobileModelList.sortedBy { it.price }
            1 -> mobileModelList.sortedByDescending { it.price }
            2 -> mobileModelList.sortedBy { it.rating }

            else -> mobileModelList
        }

    }
}