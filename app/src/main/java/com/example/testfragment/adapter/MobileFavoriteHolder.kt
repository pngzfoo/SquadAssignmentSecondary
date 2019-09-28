package com.example.testfragment.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testfragment.R
import com.example.testfragment.mobile_interface.FavoriteItemClickListener
import com.example.testfragment.model.MobileModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.mobile_favorite_card_holder.view.*

class MobileFavoriteHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.mobile_favorite_card_holder, parent, false)
) {

//    lateinit var model:MobileFavoriteModel

    fun bind(model: MobileModel, listener: FavoriteItemClickListener) {
//    fun bind(model: MobileModel) {


        itemView.setOnClickListener {
            listener.onItemClick(model)
        }

        Picasso.get()
            .load(model.thumbImageURL)
            //.placeholder(R.mipmap.ic_launcher)
            .into(itemView.picFav)
        itemView.nameFav.text = model.name
        itemView.priceFav.text = "Price: $${model.price}"
        itemView.ratingFav.text = "Rating: ${model.rating.toString()}"


//        this.model.check = model.check
//        this.model.id = model.id


    }

//    fun getCheck():Boolean{
//        return this.model.check
//    }
//
//
//    fun getId():Int{
//        return this.model.id
//    }

}