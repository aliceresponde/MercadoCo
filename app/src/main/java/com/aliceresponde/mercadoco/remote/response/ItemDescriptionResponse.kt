package com.aliceresponde.mercadoco.remote.response

import com.google.gson.annotations.SerializedName

data class ItemDescriptionResponse(
    @SerializedName("plain_text")
    val description: String
)
