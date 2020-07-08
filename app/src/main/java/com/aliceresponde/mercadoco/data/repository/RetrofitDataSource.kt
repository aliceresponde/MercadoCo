package com.aliceresponde.mercadoco.data.repository

import com.aliceresponde.mercadoco.data.remote.MercadoApiService
import com.aliceresponde.mercadoco.data.remote.response.ItemsResponse
import retrofit2.Response

class RetrofitDataSource(private val service: MercadoApiService) : RemoteDataSource {
    override suspend fun searchItem(input: String): Response<ItemsResponse> {
        return service.searchItemsBy(input)
    }

}
