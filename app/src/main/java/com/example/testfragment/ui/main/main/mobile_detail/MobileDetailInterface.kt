package com.example.testfragment.ui.main.main.mobile_detail


interface MobileDetailInterface {
    fun setMobile(
            mobileName: String,
            mobileDetailbrand: String,
            mobileDescription: String,
            mobilePrice: String,
            mobileRating: Double?,
            mobileId: Int,
            imageUrl: String?
    )
}