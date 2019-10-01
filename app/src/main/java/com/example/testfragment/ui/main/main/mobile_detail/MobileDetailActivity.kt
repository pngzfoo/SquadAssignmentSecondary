package com.example.testfragment.ui.main.main.mobile_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testfragment.MyApplication
import com.example.testfragment.R
import com.example.testfragment.adapter.ImageListAdapter
import com.example.testfragment.mobileInterface.view.MobileImagePresenterInterface
import com.example.testfragment.model.MobileImageModel
import com.example.testfragment.model.MobileModel
import com.example.testfragment.presenter.MobilePicPresenter
import kotlinx.android.synthetic.main.activity_mobile_detail.mobileBrandDetailTextView
import kotlinx.android.synthetic.main.activity_mobile_detail.mobileDetailDescriptionTextView
import kotlinx.android.synthetic.main.activity_mobile_detail.mobileDetailPriceTextView
import kotlinx.android.synthetic.main.activity_mobile_detail.mobileDetailRatingTextView
import kotlinx.android.synthetic.main.activity_mobile_detail.mobileDetailTextView
import kotlinx.android.synthetic.main.activity_mobile_detail.rvImageList

class MobileDetailActivity : BaseActivity(),
    MobileImagePresenterInterface {

    companion object {
        const val EXTRA_KEY_MODEL = "MODEL"

        fun startActivity(context: Context?, model: MobileModel) =
            context?.startActivity(
                Intent(context, MobileDetailActivity::class.java).also { intent ->
                    intent.putExtra(EXTRA_KEY_MODEL, model)
                }
            )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobile_detail)
        setView()

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    private fun setView() {

        val mobileModel: MobileModel = intent.getParcelableExtra(EXTRA_KEY_MODEL)


        mobileDetailTextView.text = mobileModel.name
        mobileBrandDetailTextView.text = mobileModel.brand
        mobileDetailDescriptionTextView.text = mobileModel.description
        mobileDetailPriceTextView.text = "Price: $${mobileModel.price}"
        mobileDetailRatingTextView.text = "Rating: ${mobileModel.rating}"

        val presenter = MobilePicPresenter(this, MyApplication.service)
        mobileModel.id.let { presenter.getImageApi(it) }

        //back button
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)


    }

    override fun setImage(mobileModelList: List<MobileImageModel>) {
        val sectionPagerAdapter = ImageListAdapter(mobileModelList)
        rvImageList.adapter = sectionPagerAdapter
        rvImageList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


    }


}