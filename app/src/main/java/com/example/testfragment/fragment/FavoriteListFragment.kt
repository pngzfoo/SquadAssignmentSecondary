package com.example.testfragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testfragment.R
import com.example.testfragment.adapter.MobileAdapter
import com.example.testfragment.adapter.MobileFavoriteAdapter
import com.example.testfragment.adapter.MobilePresenter
import com.example.testfragment.mobile_interface.MobileItemClickListener
import com.example.testfragment.mobile_interface.MobilePresenterInterface
import com.example.testfragment.model.MobileModel
import com.example.testfragment.service.MobileManager
import com.example.testfragment.sharedPreference
import com.example.testfragment.ui.main.main.mobile_detail.MobileDetailActivity
import kotlinx.android.synthetic.main.fragment_favorite.*

//class FavoriteListFragment : Fragment() {
//
//    //companion object ทำการประกาศ object declaration ใน class ด้วย keyword ชื่อว่า companion
////โดยที่ class หลักสามารถเรียกใช้ method ใน object ได้โดยตรง
//    companion object {
//        // ส่งหน้าตัวเอง
//        fun newInstance(): FavoriteListFragment =
//            FavoriteListFragment()
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.fragment_favorite, container, false)
//    }
//}


class FavoriteListFragment : Fragment(), MobilePresenterInterface {

    companion object {
        // tell that what value should send when navigate
        fun newInstance(): FavoriteListFragment = FavoriteListFragment()
    }

    private val presenter = MobilePresenter(this, MobileManager.getService())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getMobileApi()
    }

    override fun setMobile(mobileModelList: List<MobileModel>) {

        val listener = object : MobileItemClickListener {
            override fun onItemClick(mobileModel: MobileModel) {
               MobileDetailActivity.startActivity(context, mobileModel)
            }
        }
        val sectionPagerAdapter = MobileFavoriteAdapter(mobileModelList, listener)//ส่งlistener
        rvMobileFavoriteList.adapter = sectionPagerAdapter
        rvMobileFavoriteList.layoutManager = LinearLayoutManager(context)



    }
}