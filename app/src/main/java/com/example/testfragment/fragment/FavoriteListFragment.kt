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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let { context ->
            var customShared = MyCustomSharedPreference(context)
            var presenter = MobileFavoritePresenter(this, customShared)
            presenter.getMobileFavorite()
        }

    }

    override fun setMobile(mobileFavModelList: List<MobileModel>) {


        val listener = object : MobileItemClickListener {
            override fun onItemClick(mobileModel: MobileModel) {
               MobileDetailActivity.startActivity(context, mobileModel)
            }

            override fun onHeartClick(mobileModel: MobileModel) {
//                setModelFav(mobileModel)
            }

            override fun onHeartClickDelete(mobileModel: MobileModel) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
        sectionPagerAdapter = MobileFavoriteAdapter(mobileFavModelList, listener)//ส่งlistener
        rvMobileFavoriteList.adapter = sectionPagerAdapter
        rvMobileFavoriteList.layoutManager = LinearLayoutManager(context)



    }

//      override fun setTestMobile(mobileModelList: List<MobileModel>) {
//        sectionPagerAdapter.updateData(mobileModelList)
//        sectionPagerAdapter.notifyDataSetChanged()
////
//    }

    override fun setSecMobile(mobileList: List<MobileModel>) {
        sectionPagerAdapter.updateData(mobileList)
        sectionPagerAdapter.notifyDataSetChanged()
    }

    fun setModelFav(model: MobileModel) {
        sectionPagerAdapter.add(model)
        sectionPagerAdapter.notifyDataSetChanged()
    }

    fun setModelDelete(model: MobileModel) {
        sectionPagerAdapter.delete(model)
        sectionPagerAdapter.notifyDataSetChanged()
    }


}