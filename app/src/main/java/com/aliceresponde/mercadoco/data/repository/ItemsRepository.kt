package com.aliceresponde.mercadoco.data.repository

import com.aliceresponde.mercadoco.data.remote.NoInternetException
import com.aliceresponde.mercadoco.data.remote.response.ItemsResponse.Item

interface ItemsRepository {
    @Throws(NoInternetException::class)
    suspend fun searchItem(input: String): List<Item>
}