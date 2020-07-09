package com.aliceresponde.mercadoco.usecase

import com.aliceresponde.mercadoco.data.remote.NoInternetException

interface GetItemImagesUseCase {
    @Throws(NoInternetException::class)
    suspend operator fun invoke( id: String) : List<String>
}
