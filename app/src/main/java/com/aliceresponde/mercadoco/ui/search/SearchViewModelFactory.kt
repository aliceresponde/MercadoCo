package com.aliceresponde.mercadoco.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aliceresponde.mercadoco.usecase.SearchItemUseCase

class SearchViewModelFactory constructor(private val itemUseCase: SearchItemUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(SearchItemUseCase::class.java).newInstance(itemUseCase)
    }
}