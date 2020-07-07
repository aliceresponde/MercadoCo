package com.aliceresponde.mercadoco.data.remote.response

import com.google.gson.annotations.SerializedName

data class ItemDescriptionResponse(
    @SerializedName("plain_text")
    val description: String
)
