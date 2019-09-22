package com.example.testfragment

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.example.testfragment.model.MobileModel
import com.google.gson.GsonBuilder


class sharedPreference(context: Context){

//   mode in int = MODE_PRIVATE or sth
    val sharedPreference: SharedPreferences = context.getSharedPreferences("FAVORITE_FRAGMENT",MODE_PRIVATE)
    var editor = sharedPreference.edit()
    private var gson = GsonBuilder().create()

    fun  putStr(key: String, mobile: String){
//        val mobileString = gson.toJson(mobile)
        editor.putString(key,mobile).commit()
    }

    fun  getstr(key: String, c: Class<String>): String? {
        val value =  sharedPreference.getString(key, null)
        if (value != null) {
            return gson.fromJson(value, c)
        } else {
            //No JSON String with this key was found which means key is invalid or object was not saved.
            throw IllegalArgumentException("No object with key: $key was saved")
        }
    }

    fun deleteStr(key: String){
        editor.remove(key)
        editor.commit()
    }


}



