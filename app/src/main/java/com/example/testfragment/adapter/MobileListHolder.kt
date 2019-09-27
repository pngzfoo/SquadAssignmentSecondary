package com.example.testfragment.adapter


//import com.example.testfragment.MyCustomSharedPreference
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testfragment.MyCustomSharedPreference
import com.example.testfragment.R
import com.example.testfragment.mobile_interface.MobileItemClickListener
import com.example.testfragment.model.MobileModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.mobile_list_card_holder.view.*

class MobileListHolder(
    parent: ViewGroup,
    private var mobilePref: MyCustomSharedPreference?,
    val favArrayList: ArrayList<MobileModel>
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.mobile_list_card_holder, parent, false)
) {

//    private val testArrayList: ArrayList<MobileModel> = arrayListOf()


    fun bind(model: MobileModel, listener: MobileItemClickListener) {
//    fun bind(model: MobileModel) {
        itemView.setOnClickListener {
            listener.onItemClick(model)
        }

        Picasso.get()
            .load(model.thumbImageURL)
            //.placeholder(R.mipmap.ic_launcher)
            .into(itemView.mobilePic)
        itemView.mobileName.text = model.name
        itemView.mobileDescription.text = model.description
        itemView.mobilePrice.text = "Price: $${model.price}"
        itemView.mobileRating.text = "Rating: ${model.rating.toString()}"



        if (model.check) {
            itemView.heartImageButton.setBackgroundResource(R.drawable.cute_fill_heart_button)
        } else {
            itemView.heartImageButton.setBackgroundResource(R.drawable.cute_heart_button)
        }
        itemView.heartImageButton.setOnClickListener {
            if (!model.check) {
                itemView.heartImageButton.setBackgroundResource(R.drawable.cute_fill_heart_button)
                model.check = true
                favArrayList.add(model)
                mobilePref?.putModelShared(favArrayList, listener)
//                listener.onHeartClick(favArrayList)


            } else if (model.check) {
                itemView.heartImageButton.setBackgroundResource(R.drawable.cute_heart_button)
                model.check = false
                favArrayList.remove(model)
                mobilePref?.deleteStr(model.id, listener)
//                listener.onHeartClickDelete(model)
//                println(mobilePref?.getModelArrayList("TEST"))
//x
            }


        }

    }
}

