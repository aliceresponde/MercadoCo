package com.aliceresponde.mercadoco.data.repository

import com.aliceresponde.mercadoco.data.remote.MercadoApiService
import com.aliceresponde.mercadoco.data.remote.response.ItemsResponse

class ItemsRepositoryImp(private val service: MercadoApiService) : ItemsRepository {

    override suspend fun searchItem(input: String): List<ItemsResponse.Item> {
        val response = service.findItemBy(input)
        if (response.isSuccessful) {
            val result = response.body()?.results
            result?.let {
                return it
            } ?: return listOf()
        } else return listOf()
    }
}