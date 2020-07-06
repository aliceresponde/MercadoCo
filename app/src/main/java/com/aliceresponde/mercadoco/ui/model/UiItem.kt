package com.aliceresponde.mercadoco.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UiItem(
    val id: String,
    val title: String,
    val price: String,
    val thumbnail: String
) : Parcelable
