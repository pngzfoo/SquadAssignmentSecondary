package com.example.testfragment

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.testfragment.mobile_interface.MobileItemClickListener
import com.example.testfragment.model.MobileModel
import com.google.gson.GsonBuilder
import java.util.concurrent.CopyOnWriteArrayList


class MyCustomSharedPreference(context: Context) {

    //   mode in int = MODE_PRIVATE or sth
    val sharedPreference: SharedPreferences = context.getSharedPreferences("FAVORITE_FRAGMENT", MODE_PRIVATE)
    var editor = sharedPreference.edit()
    private var gson = GsonBuilder().create()

    fun putModelShared(putArray: ArrayList<MobileModel>, listener: MobileItemClickListener) {
        var sharedList = arrayListOf<MobileModel>()
        var resultList = CopyOnWriteArrayList<MobileModel>()
        val value = sharedPreference.getString("TEST", null)


//
//        if (value != null) {
////            var mList: MutableList<MobileFavoriteModel> = mutableListOf<MobileFavoriteModel>()
//            gson.fromJson(value, Array<MobileModel>::class.java).toList().apply {
//                for (i in this) {
//                    sharedList.add(i)
//                }
//            }
//
//            for (i in 0 until putArray.size) {
//                for (j in 0 until sharedList.size) {
//                    if (!(sharedList.get(j).id.equals(putArray.get(i)))) {
//                        resultList.add(sharedList.get(j))
//                    }
//
//                }
//
//            }
//        }
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

    fun getFavModelArrayList(key: String, listener: MobileItemClickListener): List<MobileModel> {
        val value = sharedPreference.getString(key, null)
        if (value != null) {
            gson.fromJson(value, Array<MobileModel>::class.java).toList().apply {
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

//class TempClass {
//    var myList: MutableList<Int> = mutableListOf<Int>()
//    fun doSomething() {
//        // myList = ArrayList<Int>() // initializer is redundant
//        myList.add(10)
//        myList.remove(10)
//    }
//}



