package com.example.testfragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testfragment.R
import com.example.testfragment.adapter.MobileFavoriteAdapter
import com.example.testfragment.mobileInterface.FavoriteItemClickListener
import com.example.testfragment.mobileInterface.view.MainInterface
import com.example.testfragment.mobileInterface.view.MobileFavoritePresenterInterface
import com.example.testfragment.model.MobileModel
import com.example.testfragment.presenter.MobileFavoritePresenter
import com.example.testfragment.presenter.MyCustomSharedPreference
import com.example.testfragment.presenter.SwipeToDeleteCallback
import com.example.testfragment.ui.main.main.mobile_detail.MobileDetailActivity
import kotlinx.android.synthetic.main.fragment_favorite.rvMobileFavoriteList

class FavoriteListFragment : Fragment(), MobileFavoritePresenterInterface {

    companion object {
        // tell that what value should send when navigate
        fun newInstance(): FavoriteListFragment = FavoriteListFragment()

        const val SORT_BY_PRICE = 0
        const val SORT_BY_REVERSE_PRICE = 1
        const val SORT_BY_RATING = 2
        const val DEFAULT = 3
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    var model: MobileModel? = null
    lateinit var mobileFavoriteAdapter: MobileFavoriteAdapter
    var presenter = MobileFavoritePresenter(this)
    private var swipeDeleteListener: MainInterface? = null


    fun swipDeleteListener(swipeDeleteListener: MainInterface) {
        this.swipeDeleteListener = swipeDeleteListener
    }

    fun sortPrice() {
        val dataMobileFavoriteList = mobileFavoriteAdapter.getMobileFavoriteList()
        val dataUpdate = presenter.sortPrice(dataMobileFavoriteList)
        setMobileThird(dataUpdate)
    }

    fun sortReversePrice() {
        val dataMobileFavoriteList = mobileFavoriteAdapter.getMobileFavoriteList()
        val dataUpdate = presenter.sortReversePrice(dataMobileFavoriteList)
        setMobileThird(dataUpdate)

    }

    fun sortRating() {
        val dataMobileFavoriteList = mobileFavoriteAdapter.getMobileFavoriteList()
        val dataUpdate = presenter.sortRating(dataMobileFavoriteList)
        setMobileThird(dataUpdate)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let { context ->
            val myCustomSharedPref = MyCustomSharedPreference(context)
            presenter.getMobileFavorite(myCustomSharedPref)
        }

    }
    override fun setMobile(mobileFavModelList: List<MobileModel>) {

        val listener = object : FavoriteItemClickListener {
            override fun onItemClick(mobileModel: MobileModel) {
                MobileDetailActivity.startActivity(context, mobileModel)
            }

            override fun onSwipeDelete(mobileModel: MobileModel) {
                swipeDeleteListener!!.getSwipeDeleted(mobileModel)
            }

        }
        mobileFavoriteAdapter = MobileFavoriteAdapter(ArrayList(mobileFavModelList), listener)//ส่งlistener
        rvMobileFavoriteList.adapter = mobileFavoriteAdapter
        rvMobileFavoriteList.layoutManager = LinearLayoutManager(context)

        val swipeHandler = object : SwipeToDeleteCallback(context!!) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = rvMobileFavoriteList.adapter as MobileFavoriteAdapter
                adapter.removeAt(viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(rvMobileFavoriteList)

    }

    override fun setMobileSecondary(mobileList: List<MobileModel>, checkedItem: Int) {
        when (checkedItem) {
            SORT_BY_PRICE -> {
                mobileFavoriteAdapter.updateData(mobileList)
                sortPrice()
            }

            SORT_BY_REVERSE_PRICE -> {
                mobileFavoriteAdapter.updateData(mobileList)
                sortReversePrice()
            }
            SORT_BY_RATING -> {
                mobileFavoriteAdapter.updateData(mobileList)
                sortRating()
            }
            DEFAULT -> {
                setMobileThird(mobileList)

            }

        }


    }

    override fun setMobileThird(mobileList: List<MobileModel>) {
        mobileFavoriteAdapter.updateData(mobileList)
        mobileFavoriteAdapter.notifyDataSetChanged()

    }


}