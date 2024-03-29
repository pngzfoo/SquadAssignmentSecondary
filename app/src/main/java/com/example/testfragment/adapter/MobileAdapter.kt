package com.example.testfragment.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testfragment.mobileInterface.MobileItemClickListener
import com.example.testfragment.model.MobileModel
import com.example.testfragment.presenter.MyCustomSharedPreference


class MobileAdapter(
    private var mobileList: List<MobileModel>,
    private val listener: MobileItemClickListener,
    private var mobilePref: MyCustomSharedPreference?

) : RecyclerView.Adapter<MobileListHolder>() {

    private val mobileArrayList: ArrayList<MobileModel> = arrayListOf()
    private var position: Int? = null

    init {//อันนี้คือให้มันแอดอันเก่าเข้าอาเรยด้วยถ้าค่ามันไม่นัล
        if (mobilePref?.getModelArrayList("TEST") != null) {
            mobileArrayList.addAll(mobilePref?.getModelArrayList("TEST")!!)
        }
    }

    fun updateData(mobileModelList: List<MobileModel>) {
        mobileList = mobileModelList
    }

    fun swipeDelete(mobileModel: MobileModel) {
        mobileArrayList.remove(mobileModel)
        mobilePref?.deleteStr(mobileModel.id, listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MobileListHolder {
        return MobileListHolder(parent, mobilePref, mobileArrayList)
    }

    override fun getItemCount(): Int = mobileList.count()

    override fun onBindViewHolder(holder: MobileListHolder, position: Int) {
        this.position = position
        holder.bind(mobileList[position], listener)

    }


}