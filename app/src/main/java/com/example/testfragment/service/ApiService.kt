package com.example.testfragment.service

import com.example.testfragment.model.MobileModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService{

    @GET("api/mobiles/")
    fun getMobileList(): Call<List<MobileModel>>

    @GET("/api/mobiles/{mobile_id}/images/")
    fun getImageById(@Path("mobile_id") mobileId: Int): Call<List<MobileModel>>

}

