package com.aliceresponde.mercadoco.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aliceresponde.mercadoco.domain.SearchUseCase

class SearchViewModelFactory constructor(private val useCase: SearchUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(SearchUseCase::class.java).newInstance(useCase)
    }
}