package com.example.testfragment.ui.main.main.mobile_detail

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testfragment.presenter.BaseView

abstract class BaseActivity : AppCompatActivity(), BaseView {

    override fun onError(str: String) {
        Toast.makeText(applicationContext, str, Toast.LENGTH_SHORT).show()
    }

}