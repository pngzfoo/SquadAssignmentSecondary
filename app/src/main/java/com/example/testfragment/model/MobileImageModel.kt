package com.example.testfragment.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MobileImageModel(
    @SerializedName("url") val url: String,
    @SerializedName("mobile_id") val mobileId: String,
    @SerializedName("id") val id: String
) : Parcelable