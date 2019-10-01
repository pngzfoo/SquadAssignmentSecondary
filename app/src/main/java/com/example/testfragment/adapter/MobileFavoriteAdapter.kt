package com.example.testfragment.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testfragment.mobileInterface.FavoriteItemClickListener
import com.example.testfragment.model.MobileModel

class MobileFavoriteAdapter(
    private var mobileFavList: ArrayList<MobileModel>,
    private val listener: FavoriteItemClickListener

) : RecyclerView.Adapter<MobileFavoriteHolder>() {


    fun updateData(list: List<MobileModel>) {
        mobileFavList.clear()
        mobileFavList.addAll(list)
    }

    fun getMobileFavoriteList(): List<MobileModel> {
        return mobileFavList

    }

    fun removeAt(position: Int) {
        var deletedModel = mobileFavList[position]
        mobileFavList.removeAt(position)
        listener.onSwipeDelete(deletedModel)
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MobileFavoriteHolder {
        return MobileFavoriteHolder(parent)
    }

    override fun getItemCount(): Int = mobileFavList.count()

    override fun onBindViewHolder(holder: MobileFavoriteHolder, position: Int) {
        holder.bind(mobileFavList[position], listener)
    }

}