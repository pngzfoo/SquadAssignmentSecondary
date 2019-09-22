package com.example.testfragment.model

import com.google.gson.annotations.SerializedName

data class MobileDetailModel(
    @SerializedName("mobile_id")
    val mobileId: String,

    @SerializedName("url")
    val imageUrl: String,

    @SerializedName("id")
    val id: String
)