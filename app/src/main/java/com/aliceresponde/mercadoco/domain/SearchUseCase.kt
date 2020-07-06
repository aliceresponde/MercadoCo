package com.aliceresponde.mercadoco.domain

import com.aliceresponde.mercadoco.remote.NoInternetException
import com.aliceresponde.mercadoco.ui.model.UiItem

interface SearchUseCase {
     @Throws(NoInternetException::class)
     suspend fun searchItem( input: String) : List<UiItem>
}
