package com.aliceresponde.mercadoco.data.repository

import com.aliceresponde.mercadoco.data.remote.response.ItemsResponse.Item

class ItemsRepositoryImp(
    private val remoteDataSource: RemoteDataSource
) : ItemsRepository {

    override suspend fun searchItem(input: String): List<Item> {
        val response = remoteDataSource.searchItems(input)
        val result = response.body()?.results
        result?.let {
            return it
        } ?: return listOf()
    }
}
