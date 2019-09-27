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
import com.example.testfragment.model.MobileModel
import com.example.testfragment.ui.main.main.mobile_detail.MobileDetailActivity
import kotlinx.android.synthetic.main.fragment_favorite.*

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

    var model: MobileModel? = null
    lateinit var sectionPagerAdapter: MobileFavoriteAdapter
    var presenter = MobileFavoritePresenter(this)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let { context ->
            var myCustomSharedPref = MyCustomSharedPreference(context)
            presenter.getMobileFavorite(myCustomSharedPref)
        }

    }

    override fun setMobile(mobileFavModelList: List<MobileModel>) {


        val listener = object : MobileItemClickListener {
            override fun onItemClick(mobileModel: MobileModel) {
               MobileDetailActivity.startActivity(context, mobileModel)
            }

            override fun onHeartClick(mobileModel: List<MobileModel>) {
//
            }

            override fun onHeartClickDelete(mobileModel: MobileModel) {

            }
        }
        sectionPagerAdapter = MobileFavoriteAdapter(ArrayList(mobileFavModelList), listener)//ส่งlistener
        rvMobileFavoriteList.adapter = sectionPagerAdapter
        rvMobileFavoriteList.layoutManager = LinearLayoutManager(context)



    }
//
//    override fun setMobileSecondary(mobileList: List<MobileModel>,checkedItem:Int) {
//        if(mobileList != null){
//            when (checkedItem) {
//                0 -> {
//                    presenter.sortPrice(mobileList)
//                }
//
//                1 -> {
//                    presenter.sortReversePrice(mobileList)
//                }
//                2 -> {
//                    presenter.sortRating(mobileList)
//                }
//                3 -> { setMobileThird(mobileList)
//
//                }
//
//            }
//        }
//
//
//    }

    override fun setMobileThird(mobileList: List<MobileModel>) {
        sectionPagerAdapter.updateData(mobileList)
        sectionPagerAdapter.notifyDataSetChanged()

    }

    fun sortPrice() {
        var dataMobileFavoriteList = sectionPagerAdapter.getMobileFavoriteList()
        var dataUpdate = presenter.sortPrice(dataMobileFavoriteList)
        setMobileThird(dataUpdate)
    }

    fun sortReversePrice() {
        var dataMobileFavoriteList = sectionPagerAdapter.getMobileFavoriteList()
        var dataUpdate = presenter.sortReversePrice(dataMobileFavoriteList)
        setMobileThird(dataUpdate)

    }

    fun sortRating() {
        var dataMobileFavoriteList = sectionPagerAdapter.getMobileFavoriteList()
        var dataUpdate = presenter.sortRating(dataMobileFavoriteList)
        setMobileThird(dataUpdate)

    }




}