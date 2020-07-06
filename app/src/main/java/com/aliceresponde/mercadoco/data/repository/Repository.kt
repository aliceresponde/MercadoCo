package com.aliceresponde.mercadoco.data.repository

import com.aliceresponde.mercadoco.remote.NoInternetException
import com.aliceresponde.mercadoco.remote.response.ItemsResponse

interface Repository {
    @Throws(NoInternetException::class)
    suspend fun searchItem(input:String): List<ItemsResponse.Item>
}