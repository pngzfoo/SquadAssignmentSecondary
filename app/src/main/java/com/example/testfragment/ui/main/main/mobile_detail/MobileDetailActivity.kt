package com.example.testfragment.ui.main.main.mobile_detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testfragment.R
import com.example.testfragment.adapter.MobilePresenter
import com.example.testfragment.mobile_interface.MobilePresenterInterface
import com.example.testfragment.model.MobileModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_mobile_detail.*

//class MobileDetailActivity : AppCompatActivity(), MobilePresenterInterface{
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_mobile_detail)
//    }
//}


class MobileDetailActivity : AppCompatActivity(), MobileDetailInterface {

    companion object {
        const val EXTRA_KEY_MODEL = "MODEL"

        fun startActivity(context: Context?, model: MobileModel) =
            context?.startActivity(
                Intent(context, MobileDetailActivity::class.java).also { intent ->
                    intent.putExtra(EXTRA_KEY_MODEL, model)
                }
            )
    }

    private val presenter = MobileDetailPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobile_detail)
        presenter.checkMobile(intent.getParcelableExtra(EXTRA_KEY_MODEL))

        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun setMobile(
        mobileName: String,
        mobileDetailbrand: String,
        mobileDescription: String,
        mobilePrice: String,
        imageUrl: String?
    ) {
        mobileDetailTextView.text = mobileName
        mobileBrandDetailTextView.text = mobileDetailbrand
        mobileDetailDescriptionTextView.text = mobileDescription
        mobileDetailPriceTextView.text = "Price: $${mobilePrice}"
        Picasso.get().load(imageUrl).into(mobileDetailImageView)
    }
}