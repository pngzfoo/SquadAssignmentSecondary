package com.example.testfragment

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.testfragment.model.MobileModel
import com.google.gson.GsonBuilder


class MyCustomSharedPreference(context: Context) {

    //   mode in int = MODE_PRIVATE or sth
    val sharedPreference: SharedPreferences = context.getSharedPreferences("FAVORITE_FRAGMENT", MODE_PRIVATE)
    var editor = sharedPreference.edit()
    private var gson = GsonBuilder().create()

    fun putModelShared(mobileM: ArrayList<MobileModel>) {
//        val mobileModelString = mobileM.toString()
        val mobileModelString = gson.toJson(mobileM)
        editor.putString("TEST", mobileModelString).commit()
    }

    fun getModelArrayList(key: String): String? {
        val value = sharedPreference.getString(key, null)

        return value //แปลงอาเรตรงนี้
    }

    fun deleteStr(key: String) {
        editor.remove(key)
        editor.commit()
    }


}



