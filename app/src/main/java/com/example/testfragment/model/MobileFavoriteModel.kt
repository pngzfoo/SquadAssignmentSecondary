package com.example.testfragment.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MobileFavoriteModel(

    @SerializedName("brand")
    val brand: String,

    @SerializedName("check")
    var check: Boolean,

    @SerializedName("description")
    val description: String,

    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("price")
    val price: String,

    @SerializedName("rating")
    val rating: Double?,

    @SerializedName("thumbImageURL")
    val thumbImageURL: String


) : Parcelable