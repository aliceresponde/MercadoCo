package com.aliceresponde.mercadoco.data.repository

import com.aliceresponde.mercadoco.data.remote.response.ItemsResponse
import retrofit2.Response

interface RemoteDataSource {
    suspend fun searchItem(input: String): Response<ItemsResponse>
}
