package com.example.testfragment.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testfragment.mobile_interface.MobileItemClickListener
import com.example.testfragment.model.MobileModel
import com.example.testfragment.sharedPreference

class MobileFavoriteAdapter(
    private val mobileList: List<MobileModel>,
    private val listener: MobileItemClickListener
) : RecyclerView.Adapter<MobileFavoriteHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MobileFavoriteHolder {
        return MobileFavoriteHolder(parent)
    }

    override fun getItemCount(): Int = mobileList.count()

    override fun onBindViewHolder(holder: MobileFavoriteHolder, position: Int) {
        holder.bind(mobileList[position],listener )
//        holder.bind(mobileList[position], listener)
    }

}