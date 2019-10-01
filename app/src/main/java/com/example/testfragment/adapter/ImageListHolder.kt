package com.example.testfragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testfragment.R
import com.example.testfragment.model.MobileImageModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_detail_card.view.mobileImage

class ImageListHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.image_detail_card, parent, false)
) {
    companion object {
        const val HTTP = "http"
        const val HTTPS = "https"
        const val WWW = "www"
        const val HTTPSWWW = "https://www"

    }

    fun bind(model: MobileImageModel) {
        val updatedUrl = when {
            model.url.contains((HTTPS)) -> model.url
            model.url.contains((HTTP)) -> model.url.replace(HTTP, HTTPS)
            else -> model.url.replace(WWW, HTTPSWWW)
        }
        Picasso.get()
            .load(updatedUrl)
            .placeholder(R.mipmap.ic_launcher)
            .into(itemView.mobileImage)
    }

}
