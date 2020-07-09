package com.aliceresponde.mercadoco.data.repository

import com.aliceresponde.mercadoco.data.remote.response.ItemDescriptionResponse
import com.aliceresponde.mercadoco.data.remote.response.ItemDetailResponse
import com.aliceresponde.mercadoco.data.remote.response.ItemsResponse
import retrofit2.Response

interface RemoteDataSource {
    suspend fun searchItems(input: String): Response<ItemsResponse>
    suspend fun getItemDetail(id: String): Response<ItemDetailResponse>
    suspend fun getItemDescription(id: String): Response<ItemDescriptionResponse>
}
