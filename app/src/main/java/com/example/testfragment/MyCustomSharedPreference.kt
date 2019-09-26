package com.example.testfragment

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.testfragment.model.MobileModel
import com.google.gson.GsonBuilder
import java.util.concurrent.CopyOnWriteArrayList


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

    fun getModelArrayList(key: String): List<MobileModel> {
        val value = sharedPreference.getString(key, null)
        if (value != null) {
            gson.fromJson(value, Array<MobileModel>::class.java).toList().apply {
                return this
            }
        }

        return listOf()//แปลงอาเรตรงนี้
    }

    fun getFavModelArrayList(key: String): List<MobileModel> {
        val value = sharedPreference.getString(key, null)
        if (value != null) {
            gson.fromJson(value, Array<MobileModel>::class.java).toList().apply {
                return this
            }
        }

        return listOf()//แปลงอาเรตรงนี้
    }

    fun deleteStr(key: Int) {

        val mList = CopyOnWriteArrayList<MobileModel>()
        val mobileModelString: String
        val value = sharedPreference.getString("TEST", null)
        if (value != null) {
//            var mList: MutableList<MobileFavoriteModel> = mutableListOf<MobileFavoriteModel>()
            gson.fromJson(value, Array<MobileModel>::class.java).toList().apply {
                for (i in this) {
                    mList.add(i)
                }
                for (j in mList) {
                    if (j.id == key) {
////                        i as String
                        mList.remove(j)
//                        editor.remove(i)
//                        editor.commit()
                    }

                }
            }
            mobileModelString = gson.toJson(mList)
            editor.putString("TEST", mobileModelString).commit()

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



