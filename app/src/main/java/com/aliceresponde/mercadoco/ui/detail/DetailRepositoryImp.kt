package com.aliceresponde.mercadoco.ui.detail

import com.aliceresponde.mercadoco.data.remote.response.ItemDetailResponse.Picture
import com.aliceresponde.mercadoco.data.repository.RemoteDataSource

class DetailRepositoryImp(private val remoteDataSource: RemoteDataSource) : DetailRepository {
    override suspend fun getItemDetail(id: String): List<Picture> {
        val response = remoteDataSource.getItemDetail(id)
        return response.body()?.let { it.pictures } ?: listOf()
    }

    override suspend fun getItemDescription(id: String): String {
        val response = remoteDataSource.getItemDescription(id)
        return response.body()?.let { it.description } ?: ""
    }
}
