package com.aliceresponde.mercadoco.usecase

import com.aliceresponde.mercadoco.data.remote.NoInternetException
import com.aliceresponde.mercadoco.ui.model.UiItem

interface SearchItemUseCase {
     @Throws(NoInternetException::class)
     suspend operator fun invoke( input: String) : List<UiItem>
}
