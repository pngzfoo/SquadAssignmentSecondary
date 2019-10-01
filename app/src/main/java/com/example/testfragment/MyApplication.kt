package com.example.testfragment

import android.app.Application
import com.example.testfragment.service.ApiService
import com.example.testfragment.service.MobileManager

class MyApplication : Application() {

    companion object {
        val service: ApiService = MobileManager().getService()
//        val getDataSharedPreferences: List<MobileModel> = MyCustomSharedPreference().getModelArrayList("Test")
    }

    override fun onCreate() {
        super.onCreate()

    }
}