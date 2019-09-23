package com.example.testfragment

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.testfragment.model.MobileModel
import com.google.gson.GsonBuilder


class sharedPreference(context: Context){

//   mode in int = MODE_PRIVATE or sth
    val sharedPreference: SharedPreferences = context.getSharedPreferences("FAVORITE_FRAGMENT",MODE_PRIVATE)
    var editor = sharedPreference.edit()
    private var gson = GsonBuilder().create()

//    fun  putStr(key: String, mobile: String){
////        val mobileString = gson.toJson(mobile)
//        editor.putString(key,mobile).commit()
//    }
//
//    fun  getstr(key: String, c: Class<String>): String? {
//        val value =  sharedPreference.getString(key, null)
//        if (value != null) {
//            return gson.fromJson(value, c)
//        } else {
//            //No JSON String with this key was found which means key is invalid or object was not saved.
//            throw IllegalArgumentException("No object with key: $key was saved")
//        }
//    }

    fun testArrayListModel(mobileM: ArrayList<MobileModel>) {
//        val mobileModelString = mobileM.toString()
        val mobileModelString = gson.toJson(mobileM)
        editor.putString("FAVORITE_FRAGMENT", mobileModelString).commit()
    }

    fun getTestArrayListModel(key: String): String? {
        val value = sharedPreference.getString(key, null)

        return value
    }

    fun deleteStr(key: String){
        editor.remove(key)
        editor.commit()
    }


}



