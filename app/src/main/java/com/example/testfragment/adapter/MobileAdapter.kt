package com.example.testfragment.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testfragment.mobile_interface.MobileItemClickListener
import com.example.testfragment.model.MobileModel

class MobileAdapter(
    private var mobileList: List<MobileModel>,
    private val listener: MobileItemClickListener
//    private var mobilePref: sharedPreference?
) : RecyclerView.Adapter<MobileListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MobileListHolder {
        return MobileListHolder(parent)
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