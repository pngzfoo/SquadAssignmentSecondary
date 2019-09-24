package com.example.testfragment.adapter

import com.example.testfragment.mobile_interface.MobilePresenterInterface
import com.example.testfragment.model.MobileModel
import com.example.testfragment.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MobilePresenter(val view: MobilePresenterInterface, private val service: ApiService) {


    fun getMobileApi() {
        service.getMobileList().enqueue(object : Callback<List<MobileModel>> {
            override fun onFailure(call: Call<List<MobileModel>>, t: Throwable) {}

            override fun onResponse(call: Call<List<MobileModel>>, response: Response<List<MobileModel>>) {
                response.body()?.apply {
                    if (this.isNotEmpty()) {
                        view.setMobile(this)
                    }
                }
            }

        })
    }

    fun sortPrice(testget: List<MobileModel>) {
        if (testget.isNotEmpty()) {
            view.setMobile(testget.sortedBy { it.price })
        }

    }


    fun sortReversePrice(testget: List<MobileModel>) {
        if (testget.isNotEmpty()) {
            view.setMobile(testget.sortedByDescending { it.price })
        }
    }


    fun sortRating(testget: List<MobileModel>) {
        if (testget.isNotEmpty()) {
            view.setMobile(testget.sortedBy { it.rating })
        }
    }

//    fun sortPrice(){
//        mobileModelList.sortedBy { it.price }
//    }
//
//    fun sortReversePrice(mobileModelList :List<MobileModel>){
//        mobileModelList.sortedByDescending { it.price }
//
//    }
//
//    fun sortRating(mobileModelList :List<MobileModel>){
//        mobileModelList.sortedBy { it.rating }
//    }


}