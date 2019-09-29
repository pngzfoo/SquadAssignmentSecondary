package com.example.testfragment.ui.main.main

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testfragment.R
import com.example.testfragment.fragment.FavoriteListFragment
import com.example.testfragment.fragment.MobileListFragment
import com.example.testfragment.mobile_interface.MainInterface
import com.example.testfragment.model.FragmentModel
import com.example.testfragment.model.MobileModel
import com.example.testfragment.ui.main.main.main.FragmentInterface
import com.example.testfragment.ui.main.main.main.FragmentPresenter
import com.example.testfragment.ui.main.main.main.IntroPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), FragmentInterface, MainInterface {

    companion object {
        const val LIST_MOBILE_TAB_NAME = "Mobile List"
        const val FAVORITE_LIST_TAB_NAME = "Favorite List"
    }

    private val presenter = FragmentPresenter(this)
    var tabList = listOf<FragmentModel>()
    var checkedItem = 3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.initView()



        val mobileListFragment = MobileListFragment.newInstance().apply { setFavoriteMobileFragment(this@MainActivity) }
        val favoriteListFragment = FavoriteListFragment.newInstance().apply { swipDeleteListener(this@MainActivity) }


        tabList = listOf(
            FragmentModel(LIST_MOBILE_TAB_NAME, mobileListFragment),
            FragmentModel(FAVORITE_LIST_TAB_NAME, favoriteListFragment)
        )
        val sectionsPagerAdapter = IntroPagerAdapter(tabList, supportFragmentManager)
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)


//      dialog for sorting
        sortImageButton.setOnClickListener {
            val listSort = arrayOf("Price low to high", "Price high to low", "Rating 5-1")
            val aBuilder = AlertDialog.Builder(this@MainActivity)

            var dataMobileList = mobileListFragment.getMobileList()
            aBuilder.setSingleChoiceItems(listSort, checkedItem) { dialogInterface, i ->
                when (i) {
                    0 -> {
                        mobileListFragment.sortPrice(dataMobileList)
                        favoriteListFragment.sortPrice()
                        checkedItem = 0
                    }

                    1 -> {
                        mobileListFragment.sortReversePrice(dataMobileList)
                        favoriteListFragment.sortReversePrice()
                        checkedItem = 1
                    }
                    2 -> {
                        mobileListFragment.sortRating(dataMobileList)
                        favoriteListFragment.sortRating()
                        checkedItem = 2
                    }
                }
                mobileListFragment.setChecked(checkedItem)
                dialogInterface.dismiss()
            }
            val aDialog = aBuilder.create()
            aDialog.show()

        }


    }

    // viewPager คือตัวที่ hold หน้าสองหน้า fragment tab รับ adaptor เข้ามา ต้องการ viewpager
    override fun setFragment() {

    }

    override fun setUpdateData(model: List<MobileModel>) {
        val favoriteFragment = tabList[1].fragment as FavoriteListFragment
        favoriteFragment.setMobileSecondary(model, checkedItem)
    }

    override fun getSwipeDeleted(mobileModel: MobileModel) {
        val mobileFragment = tabList[0].fragment as MobileListFragment
        mobileFragment.setDeleted(mobileModel, checkedItem)


    }


}