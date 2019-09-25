package com.example.testfragment.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testfragment.MyCustomSharedPreference
import com.example.testfragment.R
import com.example.testfragment.adapter.MobileAdapter
import com.example.testfragment.adapter.MobilePresenter
import com.example.testfragment.mobile_interface.MobileItemClickListener
import com.example.testfragment.mobile_interface.MobilePresenterInterface
import com.example.testfragment.model.MobileFavoriteModel
import com.example.testfragment.model.MobileModel
import com.example.testfragment.service.MobileManager
import com.example.testfragment.ui.main.main.mobile_detail.MobileDetailActivity
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A placeholder fragment containing a simple view.
 */

class MobileListFragment : Fragment(), MobilePresenterInterface {

    companion object {
        // tell that what value should send when navigate
        fun newInstance(): MobileListFragment = MobileListFragment()

    }


    //    private lateinit var presenter: MobilePresenter
    private lateinit var sharedPreference: SharedPreferences
    private var gson = GsonBuilder().create()
    private val presenter = MobilePresenter(this, MobileManager.getService())
    private var mobileList = listOf<MobileModel>()
    private lateinit var sectionPagerAdapter: MobileAdapter
//    private lateinit var customSharedPreference : MyCustomSharedPreference

//    private val imagePresenter = MobilePicPresenter (this, MobileManager.getService())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getMobileApi(getShared())

    }

    override fun setMobile(mobileModelList: List<MobileModel>) {

        mobileList = mobileModelList

        val listener = object : MobileItemClickListener {
            override fun onItemClick(mobileModel: MobileModel) {
                MobileDetailActivity.startActivity(context, mobileModel)
            }

            override fun onHeartClick(mobileModel: MobileModel) {

            }
        }
//        var mobilePref:MyCustomSharedPreference? = context?.let { MyCustomSharedPreference(it) }
//        var sortMobileList = setSort()
//       var sortMobileList = sort.sortBy(mobileModelList)

//        setAdapter(ml,listener)

        var customSharedPreference: MyCustomSharedPreference? = context?.let { MyCustomSharedPreference(it) }

        sectionPagerAdapter = MobileAdapter(mobileModelList, listener, customSharedPreference)//ส่งlistener
        rvMobileList.adapter = sectionPagerAdapter
        rvMobileList.layoutManager = LinearLayoutManager(context)

    }

    override fun setTestMobile(mobileModelList: List<MobileModel>) {
        sectionPagerAdapter.updateData(mobileModelList)
        sectionPagerAdapter.notifyDataSetChanged()
//
    }


//    fun setSort(choice: Int,mobileModelList: List<MobileModel>): List<MobileModel> {
////        sort.setChoice(choice)
//        return when (choice) {
//            0 -> mobileModelList.sortedBy { it.price }
//            1 -> mobileModelList.sortedByDescending { it.price }
//            2 -> mobileModelList.sortedBy { it.rating }
//
//            else -> mobileModelList
//        }
//
//
//    }
//    fun setInt(choice: Int): Int {
////        sort.setChoice(choice)
//        return when (choice) {
//            0 -> 0
//            1 -> 1
//            2 -> 2
//            else -> 3
//        }
//    }

//    fun setInt(choice: Int) {
//        sort.setChoice(choice)
//
//    }

//    fun setAdapter(mobileModelList: List<MobileModel>, listener:MobileItemClickListener) {
//        sectionPagerAdapter = MobileAdapter(mobileModelList, listener)//ส่งlistener
//        rvMobileList.adapter = sectionPagerAdapter
//        rvMobileList.layoutManager = LinearLayoutManager(context)
//
//    }

    fun getml(): List<MobileModel> {
        return mobileList

    }

    fun sortPrice(testget: List<MobileModel>) {
        presenter.sortPrice(testget)

    }

    fun sortReversePrice(testget: List<MobileModel>) {
        presenter.sortReversePrice(testget)

    }

    fun sortRating(testget: List<MobileModel>) {
        presenter.sortRating(testget)

    }

    fun getShared(): List<MobileFavoriteModel> {
        sharedPreference = context!!.getSharedPreferences("FAVORITE_FRAGMENT", Context.MODE_PRIVATE)
        val str: List<MobileFavoriteModel>
        val value = sharedPreference.getString("TEST", null)
        if (value != null) {
            return gson.fromJson(value, Array<MobileFavoriteModel>::class.java).toList()
        }
        return listOf()
    }

}