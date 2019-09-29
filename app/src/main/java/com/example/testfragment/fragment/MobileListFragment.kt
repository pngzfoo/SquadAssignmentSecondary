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
import com.example.testfragment.mobile_interface.MainInterface
import com.example.testfragment.mobile_interface.MobileItemClickListener
import com.example.testfragment.mobile_interface.MobilePresenterInterface
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

    private lateinit var sharedPreference: SharedPreferences
    private var gson = GsonBuilder().create()
    private val presenter = MobilePresenter(this, MobileManager.getService())
    private var mobileList = listOf<MobileModel>()
    private lateinit var mobileAdapter: MobileAdapter
    private var addFavListener: MainInterface? = null


    fun setFavoriteMobileFragment(addFavListener: MainInterface) {
        this.addFavListener = addFavListener
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

    fun setDeletedId(mobileModel: MobileModel, checkedItem: Int) {
        mobileAdapter.swipeDelete(mobileModel)
        presenter.getMobileApiSecond(getShared(), checkedItem)
    }

    fun getShared(): List<MobileModel> {
        sharedPreference = context!!.getSharedPreferences("FAVORITE_FRAGMENT", Context.MODE_PRIVATE)
//        val str: List<MobileFavoriteModel>
        val value = sharedPreference.getString("TEST", null)
        if (value != null) {
            return gson.fromJson(value, Array<MobileModel>::class.java).toList()
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
        presenter.getMobileApi(getShared())

    }

    override fun setMobile(mobileModelList: List<MobileModel>) {

        mobileList = mobileModelList

        val listener = object : MobileItemClickListener {
            override fun onItemClick(mobileModel: MobileModel) {
                MobileDetailActivity.startActivity(context, mobileModel)
            }

            override fun onHeartClick(mobileModel: List<MobileModel>) {
                addFavListener?.setUpdateData(mobileModel)
            }

        }

        var customSharedPreference: MyCustomSharedPreference? = context?.let { MyCustomSharedPreference(it) }

        mobileAdapter = MobileAdapter(mobileModelList, listener, customSharedPreference)//ส่งlistener
        rvMobileList.adapter = mobileAdapter
        rvMobileList.layoutManager = LinearLayoutManager(context)

    }

    override fun setTestMobile(mobileModelList: List<MobileModel>) {
        mobileAdapter.updateData(mobileModelList)
        mobileAdapter.notifyDataSetChanged()
    }

    override fun setMobileThird(mobileModelList: List<MobileModel>, ckeckedId: Int) {
        mobileAdapter.updateData(mobileModelList)
        mobileAdapter.notifyDataSetChanged()
    }




}