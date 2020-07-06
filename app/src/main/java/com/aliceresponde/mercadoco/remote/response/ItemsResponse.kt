package com.aliceresponde.mercadoco.remote.response

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
