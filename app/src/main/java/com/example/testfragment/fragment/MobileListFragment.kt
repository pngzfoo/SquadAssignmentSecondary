package com.example.testfragment.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testfragment.MyApplication
import com.example.testfragment.R
import com.example.testfragment.adapter.MobileAdapter
import com.example.testfragment.mobileInterface.MobileItemClickListener
import com.example.testfragment.mobileInterface.view.MainInterface
import com.example.testfragment.mobileInterface.view.MobilePresenterInterface
import com.example.testfragment.model.MobileModel
import com.example.testfragment.presenter.MobilePresenter
import com.example.testfragment.presenter.MyCustomSharedPreference
import com.example.testfragment.ui.main.main.mobile_detail.MobileDetailActivity
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_main.rvMobileList

/**
 * A placeholder fragment containing a simple view.
 */

class MobileListFragment : BaseFragment(), MobilePresenterInterface {


    companion object {
        // tell that what value should send when navigate
        fun newInstance(): MobileListFragment = MobileListFragment()
    }

    private lateinit var sharedPreference: SharedPreferences
    private var gson = GsonBuilder().create()

    private val presenter = MobilePresenter(this, MyApplication.service)

    private var mobileList = listOf<MobileModel>()
    private lateinit var mobileAdapter: MobileAdapter
    private var addFavoriteListener: MainInterface? = null
    private var checkedItem = 3


    fun setChecked(checkedItem: Int) {
        this.checkedItem = checkedItem
    }

    fun setFavoriteMobileFragment(addFavListener: MainInterface) {
        this.addFavoriteListener = addFavListener
    }

    fun getMobileList(): List<MobileModel> {
        return mobileList

    }

    fun sortPrice(mobileModelList: List<MobileModel>) {
        presenter.sortPrice(mobileModelList)

    }

    fun sortReversePrice(mobileModelList: List<MobileModel>) {
        presenter.sortReversePrice(mobileModelList)

    }

    fun sortRating(mobileModelList: List<MobileModel>) {
        presenter.sortRating(mobileModelList)

    }

    fun setDeleted(mobileModel: MobileModel, checkedItem: Int) {
        mobileAdapter.swipeDelete(mobileModel)
        presenter.getMobileApi(getDataSharedPref(), checkedItem)
    }

    private fun getDataSharedPref(): List<MobileModel> {
        sharedPreference = context!!.getSharedPreferences("FAVORITE_FRAGMENT", Context.MODE_PRIVATE)
        val sharedPrefData = sharedPreference.getString("TEST", null)
        if (sharedPrefData != null) {
            return gson.fromJson(sharedPrefData, Array<MobileModel>::class.java).toList()
        }
        return listOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getMobileApi(getDataSharedPref(), checkedItem)

    }

    override fun setMobile(mobileModelList: List<MobileModel>) {

        mobileList = mobileModelList

        val listener = object : MobileItemClickListener {
            override fun onItemClick(mobileModel: MobileModel) {
                MobileDetailActivity.startActivity(context, mobileModel)
            }

            override fun onHeartClick(mobileModel: List<MobileModel>) {
                addFavoriteListener?.setUpdateData(mobileModel)
            }

        }

        var customSharedPreference: MyCustomSharedPreference? = context?.let { MyCustomSharedPreference(it) }

        mobileAdapter = MobileAdapter(mobileModelList, listener, customSharedPreference)
        rvMobileList.adapter = mobileAdapter
        rvMobileList.layoutManager = LinearLayoutManager(context)

    }

    override fun setMobileSecond(mobileModelList: List<MobileModel>) {
        mobileAdapter.updateData(mobileModelList)
        mobileAdapter.notifyDataSetChanged()
    }

    override fun setView(): View? {
        presenter.setView(view)
        return view
    }


}