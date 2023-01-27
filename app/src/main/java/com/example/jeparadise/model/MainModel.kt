package com.example.jeparadise.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainModel (
    var distance : Int? = 0,
    var location : String? = null,
    var name : String? = null,
    var url : String? = null,
    var description : String? = null,
    var category : String? = null
) : Parcelable