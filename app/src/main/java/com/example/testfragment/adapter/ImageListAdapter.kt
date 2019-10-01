package com.example.testfragment.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testfragment.model.MobileImageModel

class ImageListAdapter(
    private val mobileImageList: List<MobileImageModel>

) : RecyclerView.Adapter<ImageListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListHolder {
        return ImageListHolder(parent)
    }

    override fun getItemCount(): Int = mobileImageList.count()

    override fun onBindViewHolder(holder: ImageListHolder, position: Int) {
        holder.bind(mobileImageList[position])
    }

}