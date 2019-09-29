package com.example.testfragment

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.testfragment.mobile_interface.MobileItemClickListener
import com.example.testfragment.model.MobileModel
import com.google.gson.GsonBuilder
import java.util.concurrent.CopyOnWriteArrayList


class MyCustomSharedPreference(context: Context) {

    //   mode in int = MODE_PRIVATE or smth
    val sharedPreference: SharedPreferences = context.getSharedPreferences("FAVORITE_FRAGMENT", MODE_PRIVATE)
    var editor = sharedPreference.edit()
    private var gson = GsonBuilder().create()

    fun putModelShared(putArray: ArrayList<MobileModel>, listener: MobileItemClickListener) {
        val mobileModelString = gson.toJson(putArray)
        editor.putString("TEST", mobileModelString).commit()
        listener.onHeartClick(putArray)
    }

    fun getModelArrayList(key: String): List<MobileModel> {
        val dataString = sharedPreference.getString(key, null)
        if (dataString != null) {
            gson.fromJson(dataString, Array<MobileModel>::class.java).toList().apply {
                return this
            }
        }

        return listOf()//แปลงอาเรตรงนี้
    }

    fun deleteStr(deletedId: Int, listener: MobileItemClickListener) {

        val tempList = CopyOnWriteArrayList<MobileModel>()
        val tempListToReturn = arrayListOf<MobileModel>()

        val sharePreferenceDataString = sharedPreference.getString("TEST", null)
        if (sharePreferenceDataString != null) {

            gson.fromJson(sharePreferenceDataString, Array<MobileModel>::class.java).toList().apply {
                for (model in this) {
                    tempList.add(model)
                }
                for (model in tempList) {
                    if (model.id == deletedId)
                        tempList.remove(model)
                }
                for (model in tempList) {
                    tempListToReturn.add(model)
                }
            }

            val mobileModelString = gson.toJson(tempList)
            editor.clear()
            editor.putString("TEST", mobileModelString).commit()

            listener.onHeartClick(tempListToReturn)
        }

    }
}



