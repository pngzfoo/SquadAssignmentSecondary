package com.example.testfragment.presenter

import com.example.testfragment.mobile_interface.MobileImagePresenterInterface
import com.example.testfragment.model.MobileImageModel
import com.example.testfragment.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MobilePicPresenter(val view: MobileImagePresenterInterface, private val service: ApiService) {


    fun getImageApi(id: Int) {
        service.getImageById(id).enqueue(object : Callback<List<MobileImageModel>> {
            override fun onFailure(call: Call<List<MobileImageModel>>, t: Throwable) {}

            override fun onResponse(call: Call<List<MobileImageModel>>, response: Response<List<MobileImageModel>>) {
                response.body()?.apply {
                    if (this.isNotEmpty()) {
                        view.setImage(this)
                    }
                }
            }

        })
    }

}