package com.example.testfragment.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MobileManager {

    companion object {
        const val MOBILE_LIST_API = "https://scb-test-mobile.herokuapp.com/"
    }


    fun getService(): ApiService {
        val instance = Retrofit.Builder()
            .baseUrl(MOBILE_LIST_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .run { create(ApiService::class.java) }
        return instance as ApiService
    }
}
