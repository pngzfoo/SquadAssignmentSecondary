package com.example.testfragment.ui.main.main.mobile_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testfragment.R
import com.example.testfragment.adapter.ImageListAdapter
import com.example.testfragment.adapter.MobilePicPresenter
import com.example.testfragment.mobile_interface.MobileImagePresenterInterface
import com.example.testfragment.model.MobileImageModel
import com.example.testfragment.model.MobileModel
import com.example.testfragment.service.MobileManager
import kotlinx.android.synthetic.main.activity_mobile_detail.*

//class MobileDetailActivity : AppCompatActivity(), MobilePresenterInterface{
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_mobile_detail)
//    }
//}


class MobileDetailActivity : AppCompatActivity(), MobileImagePresenterInterface {

    companion object {
        const val EXTRA_KEY_MODEL = "MODEL"

        fun startActivity(context: Context?, model: MobileModel) =
            context?.startActivity(
                Intent(context, MobileDetailActivity::class.java).also { intent ->
                    intent.putExtra(EXTRA_KEY_MODEL, model)
                }
            )
    }

//    private val presenter = MobileDetailPresenter(this)
//    private val imagePresenter = MobilePicPresenter(this)//

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

        var mobileModel: MobileModel = intent.getParcelableExtra(EXTRA_KEY_MODEL)

        mobileDetailTextView.text = mobileModel.name
        mobileBrandDetailTextView.text = mobileModel.brand
        mobileDetailDescriptionTextView.text = mobileModel.description
        mobileDetailPriceTextView.text = "Price: $${mobileModel.price}"
        mobileDetailRatingTextView.text = "Rating: ${mobileModel.rating}"

        val presenter = MobilePicPresenter(this, MobileManager.getService())
        presenter.getMobileApi(mobileModel.id)


        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

    }

    override fun setImage(mobileModelList: List<MobileImageModel>) {
        val sectionPagerAdapter = ImageListAdapter(mobileModelList)
        rvImageList.adapter = sectionPagerAdapter
        rvImageList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


    }


////    override fun setMobileImage
//
//    override fun setMobile(
//        mobileName: String,
//        mobileDetailbrand: String,
//        mobileDescription: String,
//        mobilePrice: String,
//        mobileRating: Double?,
//        mobileId:String,
//        imageUrl: String?
//    ) {
//        mobileDetailTextView.text = mobileName
//        mobileBrandDetailTextView.text = mobileDetailbrand
//        mobileDetailDescriptionTextView.text = mobileDescription
//        mobileDetailPriceTextView.text = "Price: $${mobilePrice}"
//        mobileDetailRatingTextView.text = "Rating: ${mobileRating}"
//        Picasso.get().load(imageUrl).into(mobileDetailImageView1)
//    }
}