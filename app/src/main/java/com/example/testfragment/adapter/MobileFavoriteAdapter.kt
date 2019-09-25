package com.example.testfragment.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testfragment.mobile_interface.MobileItemClickListener
import com.example.testfragment.model.MobileFavoriteModel

class MobileFavoriteAdapter(
    private val mobileFavList: List<MobileFavoriteModel>,
    private val listener: MobileItemClickListener,
    val map: HashMap<Int, String> = hashMapOf(1 to "x", 2 to "y", -1 to "zz")
) : RecyclerView.Adapter<MobileFavoriteHolder>() {

//    private lateinit var id: Int
//    private var check: Boolean


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MobileFavoriteHolder {
        return MobileFavoriteHolder(parent)
    }

    override fun getItemCount(): Int = mobileFavList.count()

    override fun onBindViewHolder(holder: MobileFavoriteHolder, position: Int) {
        holder.bind(mobileFavList[position], listener)
//        holder.bind(mobileList[position], listener)
//        check = holder.getCheck()
//        id = holder.getId()
    }

//
//    fun getCheck():Boolean{
//        return check
//    }
//
//
//    fun getId():Int{
//        return id
//    }


}