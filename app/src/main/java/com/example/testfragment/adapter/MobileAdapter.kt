package com.example.testfragment.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testfragment.MyCustomSharedPreference
import com.example.testfragment.mobile_interface.MobileItemClickListener
import com.example.testfragment.model.MobileModel

class MobileAdapter(
    private var mobileList: List<MobileModel>,
    private val listener: MobileItemClickListener,
    private var mobilePref: MyCustomSharedPreference?

//    private val testArrayList:ArrayList<MobileModel> = arrayListOf()//
) : RecyclerView.Adapter<MobileListHolder>() {

    private val testArrayList: ArrayList<MobileModel> = arrayListOf()

//    init {//อันนี้คือให้มันแอดอันเก่าเข้าอาเรยด้วยถ้าค่ามันไม่นัล
//        mobilePref?.getModelArrayList("TEST")?.let { testArrayList.addAll(mobileList) }
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MobileListHolder {
        return MobileListHolder(parent, mobilePref, testArrayList)
    }

    override fun getItemCount(): Int = mobileList.count()

    override fun onBindViewHolder(holder: MobileListHolder, position: Int) {
        holder.bind(mobileList[position],listener)
//        holder.bind(mobileList[position], listener)
    }

    fun updateData(mobileModelList: List<MobileModel>) {
        mobileList = mobileModelList
    }

}