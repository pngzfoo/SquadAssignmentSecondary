package com.example.testfragment.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testfragment.R

/**
 * A placeholder fragment containing a simple view.
 */
class MobileListFragment : Fragment() {


    //companion object ทำการประกาศ object declaration ใน class ด้วย keyword ชื่อว่า companion
//โดยที่ class หลักสามารถเรียกใช้ method ใน object ได้โดยตรง
    companion object {
        // ส่งหน้าตัวเอง
        fun newInstance(): MobileListFragment = MobileListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

}