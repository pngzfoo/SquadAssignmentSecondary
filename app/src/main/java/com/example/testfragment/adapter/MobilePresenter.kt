package com.example.testfragment.adapter


import com.example.testfragment.mobile_interface.MobilePresenterInterface
import com.example.testfragment.model.MobileModel
import com.example.testfragment.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MobilePresenter(val view: MobilePresenterInterface, private val service: ApiService) {


    fun getMobileApi(mobileFavList: List<MobileModel>) {
        service.getMobileList().enqueue(object : Callback<List<MobileModel>> {
            override fun onFailure(call: Call<List<MobileModel>>, t: Throwable) {}

            override fun onResponse(call: Call<List<MobileModel>>, response: Response<List<MobileModel>>) {
                response.body()?.apply {
                    if (this.isNotEmpty()) {

                        if (mobileFavList != null) {
                            for (i in this) {
                                for (j in mobileFavList) {
                                    if (i.id == j.id) {
                                        i.check = true
                                    }
                                }
                            }
                        }
                        view.setMobile(this)

                    }
                }
            }

        })
    }

    fun getMobileApiSecond(mobileFavList: List<MobileModel>, checkedItem: Int) {
        service.getMobileList().enqueue(object : Callback<List<MobileModel>> {
            override fun onFailure(call: Call<List<MobileModel>>, t: Throwable) {}

            override fun onResponse(call: Call<List<MobileModel>>, response: Response<List<MobileModel>>) {
                response.body()?.apply {
                    if (this.isNotEmpty()) {

                        if (mobileFavList != null) {
                            for (i in this) {
                                for (j in mobileFavList) {
                                    if (i.id == j.id) {
                                        i.check = true
                                    }
                                }
                            }
                        }

                        when (checkedItem) {
                            0 -> {
                                view.setTestMobile(this.sortedBy { it.price })
                            }
                            1 -> {
                                view.setTestMobile(this.sortedByDescending { it.price })
                            }
                            2 -> {
                                view.setTestMobile(this.sortedBy { it.rating })
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
            view.setTestMobile(mobileModelList.sortedBy { it.price })
        }

    }


    fun sortReversePrice(mobileModelList: List<MobileModel>) {
        if (mobileModelList.isNotEmpty()) {
            view.setTestMobile(mobileModelList.sortedByDescending { it.price })
        }
    }


    fun sortRating(mobileModelList: List<MobileModel>) {
        if (mobileModelList.isNotEmpty()) {
            view.setTestMobile(mobileModelList.sortedBy { it.rating })
        }
    }

}