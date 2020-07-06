package com.aliceresponde.mercadoco.data.repository

import com.aliceresponde.mercadoco.remote.MercadoApi
import com.aliceresponde.mercadoco.remote.response.ItemsResponse

class RepositoryImp(private val service: MercadoApi) : Repository {

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