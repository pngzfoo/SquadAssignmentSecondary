package com.example.testfragment.adapter


//import com.example.testfragment.sharedPreference
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testfragment.R
import com.example.testfragment.mobile_interface.MobileItemClickListener
import com.example.testfragment.model.MobileModel
import com.example.testfragment.sharedPreference
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.mobile_favorite_card_holder.view.*
import kotlinx.android.synthetic.main.mobile_list_card_holder.view.*

class MobileListHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.mobile_list_card_holder, parent, false)
) {


    fun bind(model: MobileModel, listener: MobileItemClickListener) {
//    fun bind(model: MobileModel) {
        itemView.setOnClickListener {
            listener.onItemClick(model)
        }

        Picasso.get()
            .load(model.thumbImageURL)
            //.placeholder(R.mipmap.ic_launcher)
            .into(itemView.mobilePic)
        itemView.mobileDescription.text = model.description
        itemView.mobilePrice.text = "Price: $${model.price}"
        itemView.mobileRating.text = "Rating: ${model.rating.toString()}"


//        fun <T> mutableSetOf(): MutableSet<T>
//        val ms = setOf(model.name,model.price,model.brand,model.description,model.rating)
//        var modelPref : sharedPreference? = context?.let {sharedPreference(it)}


        itemView.heartImageButton.setOnClickListener {
            if (model.check == false) {
                itemView.heartImageButton.setBackgroundResource(R.drawable.cute_heart_button)
                model.check = true
//                mobilePref?.putStr(model.id,"${model.check}")
//                println(mobilePref?.getstr("${model.id}",MobileModel::class.java))

            } else if (model.check == true) {
                itemView.heartImageButton.setBackgroundResource(R.drawable.cute_fill_heart_button)
                model.check = false
//                mobilePref?.putStr(model.id,"${model.check}")

//                mobilePref?.deleteStr("1")
//                var user_id = sharedPref.sharedPreference.getInt("userId", -1);
            }
        }


    }

}

