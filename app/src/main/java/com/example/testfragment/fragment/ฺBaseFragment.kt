package com.example.testfragment.fragment

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.testfragment.mobileInterface.view.BaseView

abstract class BaseFragment : Fragment(), BaseView {

    abstract fun setView(): View?

    override fun onError(str: String) {
        Toast.makeText(view?.context, str, Toast.LENGTH_SHORT).show()
    }

}