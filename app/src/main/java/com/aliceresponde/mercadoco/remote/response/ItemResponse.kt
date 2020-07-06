package com.aliceresponde.mercadoco.remote.response

data class ItemResponse(
    val id: String,
    val title: String,
    val pictures: List<Picture>
) {
    data class Picture(
        val secure_url: String
    )
}
