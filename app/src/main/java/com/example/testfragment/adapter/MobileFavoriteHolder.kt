package com.example.testfragment.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testfragment.R
import com.example.testfragment.mobileInterface.FavoriteItemClickListener
import com.example.testfragment.model.MobileModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.mobile_favorite_card_holder.view.nameFav
import kotlinx.android.synthetic.main.mobile_favorite_card_holder.view.picFav
import kotlinx.android.synthetic.main.mobile_favorite_card_holder.view.priceFav
import kotlinx.android.synthetic.main.mobile_favorite_card_holder.view.ratingFav

class MobileFavoriteHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.mobile_favorite_card_holder, parent, false)
) {


    fun bind(model: MobileModel, listener: FavoriteItemClickListener) {
        itemView.setOnClickListener {
            listener.onItemClick(model)
        }

        Picasso.get()
            .load(model.thumbImageURL)
            .placeholder(R.mipmap.ic_launcher)
            .into(itemView.picFav)
        itemView.nameFav.text = model.name
        itemView.priceFav.text = "Price: $${model.price}"
        itemView.ratingFav.text = "Rating: ${model.rating.toString()}"

    }
}
