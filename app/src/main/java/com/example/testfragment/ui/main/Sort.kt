package com.example.testfragment.ui.main

import com.example.testfragment.model.MobileModel


class Sort {
//class Sort(mobileModelList: List<MobileModel>) {


    var int: Int = 3
    lateinit var mobileModelList: List<MobileModel>

//    fun setChoice(int : Int) :List<MobileModel>{
//        this.int = int
//        return sortBy(mobileModelList)
//    }

    fun setChoice(int: Int) {
        this.int = int
    }

    fun sortBy(mobileModelList: List<MobileModel>) :List<MobileModel> {

        return when (int) {
            0 -> mobileModelList.sortedBy { it.price }
            1 -> mobileModelList.sortedByDescending { it.price }
            2 -> mobileModelList.sortedBy { it.rating }

            else -> mobileModelList
        }

    }


}