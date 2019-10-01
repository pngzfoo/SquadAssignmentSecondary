package com.example.testfragment.presenter


import com.example.testfragment.mobileInterface.view.MobilePresenterInterface
import com.example.testfragment.model.MobileModel
import com.example.testfragment.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MobilePresenter(
    val view: MobilePresenterInterface,
    private val service: ApiService
) : BaseListPresenter() {

    companion object {
        const val SORT_BY_PRICE = 0
        const val SORT_BY_REVERSE_PRICE = 1
        const val SORT_BY_RATING = 2
        const val DEFAULT = 3
    }


    fun getMobileApi(mobileFavoriteList: List<MobileModel>, checkedItem: Int) {
        service.getMobileList().enqueue(object : Callback<List<MobileModel>> {
            override fun onFailure(call: Call<List<MobileModel>>, t: Throwable) {
                view.onError("Get API Fail")
            }

            override fun onResponse(call: Call<List<MobileModel>>, response: Response<List<MobileModel>>) {
                response.body()?.apply {
                    if (this.isNotEmpty()) {
                        for (mobileModel in this) {
                            for (mobileModelSharedPref in mobileFavoriteList) {
                                if (mobileModel.id == mobileModelSharedPref.id) {
                                    mobileModel.check = true
                                }
                            }
                        }
                        when (checkedItem) {
                            SORT_BY_PRICE -> {
                                view.setMobileSecond(this.sortedBy { it.price })
                            }
                            SORT_BY_REVERSE_PRICE -> {
                                view.setMobileSecond(this.sortedByDescending { it.price })
                            }
                            SORT_BY_RATING -> {
                                view.setMobileSecond(this.sortedBy { it.rating })
                            }
                            DEFAULT -> {
                                view.setMobile(this)
                            }
                        }

                    }
                }
            }

        })
    }
}