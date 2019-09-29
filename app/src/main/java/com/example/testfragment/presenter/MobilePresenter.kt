package com.example.testfragment.presenter


import com.example.testfragment.mobile_interface.MobilePresenterInterface
import com.example.testfragment.model.MobileModel
import com.example.testfragment.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MobilePresenter(val view: MobilePresenterInterface, private val service: ApiService) {


    fun getMobileApi(mobileFavoriteList: List<MobileModel>, checkedItem: Int) {
        service.getMobileList().enqueue(object : Callback<List<MobileModel>> {
            override fun onFailure(call: Call<List<MobileModel>>, t: Throwable) {}

            override fun onResponse(call: Call<List<MobileModel>>, response: Response<List<MobileModel>>) {
                response.body()?.apply {
                    if (this.isNotEmpty()) {

                        if (mobileFavoriteList != null) {
                            for (mobileModel in this) {
                                for (mobileModelSharedPref in mobileFavoriteList) {
                                    if (mobileModel.id == mobileModelSharedPref.id) {
                                        mobileModel.check = true
                                    }
                                }
                            }
                        }
                        when (checkedItem) {
                            0 -> {
                                view.setMobileSecond(this.sortedBy { it.price })
                            }
                            1 -> {
                                view.setMobileSecond(this.sortedByDescending { it.price })
                            }
                            2 -> {
                                view.setMobileSecond(this.sortedBy { it.rating })
                            }
                            3 -> {
                                view.setMobile(this)
                            }
                        }

                    }
                }
            }

        })
    }


    fun sortPrice(mobileModelList: List<MobileModel>) {
        if (mobileModelList.isNotEmpty()) {
            view.setMobileSecond(mobileModelList.sortedBy { it.price })
        }

    }


    fun sortReversePrice(mobileModelList: List<MobileModel>) {
        if (mobileModelList.isNotEmpty()) {
            view.setMobileSecond(mobileModelList.sortedByDescending { it.price })
        }
    }


    fun sortRating(mobileModelList: List<MobileModel>) {
        if (mobileModelList.isNotEmpty()) {
            view.setMobileSecond(mobileModelList.sortedBy { it.rating })
        }
    }

}