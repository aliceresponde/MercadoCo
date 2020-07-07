package com.aliceresponde.mercadoco.data.remote.response

data class ItemsResponse(
    val results: List<Item>
) {

    data class Item(
        val id: String,
        val title: String,
        val price: Long,
        val thumbnail: String
    )

}
