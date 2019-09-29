package com.example.testfragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testfragment.R
import com.example.testfragment.model.MobileImageModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_detail_card.view.*

class ImageListHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.image_detail_card, parent, false)
) {

    fun bind(model: MobileImageModel) {
        var updatedUrl: String
        if (model.url.contains(("https"))) {
            updatedUrl = model.url
        } else if (model.url.contains(("http"))) {
            updatedUrl = model.url.replace("http", "https")
        } else {
            updatedUrl = model.url.replace("www", "https://www")
        }
        Picasso.get()
                .load(updatedUrl)
            .placeholder(R.mipmap.ic_launcher)
                .into(itemView.mobileImage)
    }

}
