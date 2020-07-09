package com.aliceresponde.mercadoco.ui.detail

import com.aliceresponde.mercadoco.data.remote.NoInternetException
import com.aliceresponde.mercadoco.data.remote.response.ItemDescriptionResponse
import com.aliceresponde.mercadoco.data.remote.response.ItemDetailResponse
import com.aliceresponde.mercadoco.data.remote.response.ItemDetailResponse.Picture

interface DetailRepository {
    @Throws(NoInternetException::class)
    suspend  fun getItemDetail(id: String): List<Picture>

    @Throws(NoInternetException::class)
    suspend  fun getItemDescription(id: String): String
}
