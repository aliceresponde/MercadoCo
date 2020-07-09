package com.aliceresponde.mercadoco.data.remote.response

data class ItemDetailResponse(
    val id: String,
    val title: String,
    val pictures: List<Picture>
) {
    data class Picture(
        val secure_url: String
    )
}
