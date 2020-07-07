package com.aliceresponde.mercadoco.di

import com.aliceresponde.mercadoco.data.repository.ItemsRepository
import com.aliceresponde.mercadoco.ui.search.SearchViewModel
import com.aliceresponde.mercadoco.usecase.SearchItemUC
import com.aliceresponde.mercadoco.usecase.SearchItemUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class SearchFragmentModule {

//    @Provides
//    fun providesSearchViewModel(useCase :SearchItemUC)  = SearchViewModel(useCase)

    @Provides
    fun providesSearchItemUC(repository: ItemsRepository) : SearchItemUseCase = SearchItemUC(repository)
}