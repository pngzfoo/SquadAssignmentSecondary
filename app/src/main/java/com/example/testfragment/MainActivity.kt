package com.example.testfragment

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testfragment.fragment.FavoriteListFragment
import com.example.testfragment.fragment.MobileListFragment
import com.example.testfragment.model.FragmentModel
import com.example.testfragment.ui.main.main.main.FragmentInterface
import com.example.testfragment.ui.main.main.main.FragmentPresenter
import com.example.testfragment.ui.main.main.main.IntroPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), FragmentInterface {

    companion object {
        const val LIST_MOBILE_TAB_NAME = "Mobile List"
        const val FAVORITE_LIST_TAB_NAME = "Favorite List"
    }

    //    var int: Int = 0
    private val presenter = FragmentPresenter(this)

//    private lateinit var sectionsPagerAdapter: IntroPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.initView()
//


        val mobileListFragment = MobileListFragment.newInstance()
        val favoriteListFragment = FavoriteListFragment.newInstance()

        val tabList = listOf(
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
//            val mainFrag = sectionsPagerAdapter.getItem(0)//เรียกฟังก์ชันแท็ปนั้นมา
//            var testget = listOf<MobileModel>()
//            if (mainFrag is MobileListFragment) {
//                 testget = mainFrag.getml()
//            }

            var testget = mobileListFragment.getml()
            aBuilder.setSingleChoiceItems(listSort, -1) { dialogInterface, i ->
                run {
                    when (i) {
                        0 -> mobileListFragment.sortPrice(testget)
                        1 -> mobileListFragment.sortReversePrice(testget)
                        2 -> mobileListFragment.sortRating(testget)
                    }
                }
                dialogInterface.dismiss()
            }
            val aDialog = aBuilder.create()
            aDialog.show()

        }


    }

    // viewPager คือตัวที่ hold หน้าสองหน้า fragment tab รับ adaptor เข้ามา ต้องการ viewpager
    override fun setFragment() {
//        val mobileListFragment = MobileListFragment.newInstance()
//        mobileListFragment.setInt(int)
//        val favoriteListFragment = FavoriteListFragment.newInstance()
//        val tabList = listOf(
//                FragmentModel(MainActivity.LIST_MOBILE_TAB_NAME, mobileListFragment),
//                FragmentModel(MainActivity.FAVORITE_LIST_TAB_NAME, favoriteListFragment)
//        )
//        val sectionsPagerAdapter = IntroPagerAdapter(tabList, supportFragmentManager)
//        view_pager.adapter = sectionsPagerAdapter
//        tabs.setupWithViewPager(view_pager)
    }

}