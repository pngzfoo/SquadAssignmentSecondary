package com.example.testfragment.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testfragment.mobile_interface.MobileItemClickListener
import com.example.testfragment.model.MobileModel
import com.google.gson.GsonBuilder

class MobileFavoriteAdapter(
    private var mobileFavList: List<MobileModel>,
    private val listener: MobileItemClickListener

) : RecyclerView.Adapter<MobileFavoriteHolder>() {

    private var gson = GsonBuilder().create()

//     var arrayModel = arrayListOf<List<MobileFavoriteModel>>()
//    val objectList = gson.fromJson(json, Array<SomeObject>::class.java).asList()


    //
//    fun addList(){
//        arrayModel.add(mobileFavList)
//        notifyDataSetChanged()
//    }
    fun add(model: MobileModel) {
        val newList = mobileFavList.toMutableList()
        newList.add(model)
        mobileFavList = newList
    }

    fun delete(model: MobileModel) {
        val newList = mobileFavList.toMutableList()
        newList.remove(model)
        mobileFavList = newList
    }

    fun updateData(list: List<MobileModel>) {
        mobileFavList = list.toMutableList()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MobileFavoriteHolder {
        return MobileFavoriteHolder(parent)
    }

    override fun getItemCount(): Int = mobileFavList.count()

    override fun onBindViewHolder(holder: MobileFavoriteHolder, position: Int) {
        holder.bind(mobileFavList[position], listener)
    }

//    fun MobileModel.toMobileFavoriteModel(): MobileFavoriteModel {
//        val mobileNew = MobileFavoriteModel()
//        mobileNew.id = id
//        mobileNew.name = name
//        mobileNew.check = check
//        mobileNew.brand = brand
//        mobileNew.description = description
//        mobileNew.price = price
//        mobileNew.rating = rating
//        mobileNew.thumbImageURL = thumbImageURL
//        return mobileNew
//    }


}