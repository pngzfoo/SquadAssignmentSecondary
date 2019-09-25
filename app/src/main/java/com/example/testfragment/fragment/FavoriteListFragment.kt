package com.example.testfragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testfragment.MyCustomSharedPreference
import com.example.testfragment.R
import com.example.testfragment.adapter.MobileFavoriteAdapter
import com.example.testfragment.adapter.MobileFavoritePresenter
import com.example.testfragment.mobile_interface.MobileFavoritePresenterInterface
import com.example.testfragment.mobile_interface.MobileItemClickListener
import com.example.testfragment.model.MobileFavoriteModel
import com.example.testfragment.model.MobileModel
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


class FavoriteListFragment : Fragment(), MobileFavoritePresenterInterface {

    companion object {
        // tell that what value should send when navigate
        fun newInstance(): FavoriteListFragment = FavoriteListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    lateinit var presenter: MobileFavoritePresenter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let { context ->
            var customShared = MyCustomSharedPreference(context)
            presenter = MobileFavoritePresenter(this, customShared)
        }
        presenter.getMobileFavorite()
    }

    override fun setMobile(mobileFavModelList: List<MobileFavoriteModel>) {

        val listener = object : MobileItemClickListener {
            override fun onItemClick(mobileModel: MobileModel) {
               MobileDetailActivity.startActivity(context, mobileModel)
            }

            override fun onHeartClick(mobileModel: MobileModel) {

            }
        }
        val sectionPagerAdapter = MobileFavoriteAdapter(mobileFavModelList, listener)//ส่งlistener
        rvMobileFavoriteList.adapter = sectionPagerAdapter
        rvMobileFavoriteList.layoutManager = LinearLayoutManager(context)



    }


}