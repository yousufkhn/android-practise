package com.example.androidclassapp.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Flower(
    val name: String,
    val price: Int,
    val imageResId: Int,
    var quantityInCart: Int = 0
)