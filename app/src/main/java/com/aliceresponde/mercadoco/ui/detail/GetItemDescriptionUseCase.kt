package com.aliceresponde.mercadoco.ui.detail

import com.aliceresponde.mercadoco.data.remote.NoInternetException

interface GetItemDescriptionUseCase {
    @Throws(NoInternetException::class)
    suspend operator fun invoke(id: String): String
}
