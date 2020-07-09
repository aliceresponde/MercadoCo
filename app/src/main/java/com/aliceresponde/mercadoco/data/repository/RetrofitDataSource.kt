package com.aliceresponde.mercadoco.data.repository

import com.aliceresponde.mercadoco.data.remote.MercadoApiService
import com.aliceresponde.mercadoco.data.remote.response.ItemDescriptionResponse
import com.aliceresponde.mercadoco.data.remote.response.ItemDetailResponse
import com.aliceresponde.mercadoco.data.remote.response.ItemsResponse
import retrofit2.Response

class RetrofitDataSource(private val service: MercadoApiService) : RemoteDataSource {
    override suspend fun searchItems(input: String): Response<ItemsResponse> {
        return service.searchItemsBy(input)
    }

    override suspend fun getItemDetail(id: String): Response<ItemDetailResponse> {
        return service.getItemDetail(id)
    }

    override suspend fun getItemDescription(id: String): Response<ItemDescriptionResponse> {
        return service.getItemDescription(id)
    }
}
