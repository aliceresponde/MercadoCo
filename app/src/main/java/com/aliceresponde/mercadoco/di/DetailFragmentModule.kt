package com.aliceresponde.mercadoco.di

import com.aliceresponde.mercadoco.ui.detail.DetailRepository
import com.aliceresponde.mercadoco.ui.detail.DetailViewModel
import com.aliceresponde.mercadoco.ui.detail.GetItemDescriptionUseCase
import com.aliceresponde.mercadoco.ui.detail.GetItemDescriptionUseCaseImp
import com.aliceresponde.mercadoco.usecase.GetItemImagesUseCase
import com.aliceresponde.mercadoco.usecase.GetItemImagesUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class DetailFragmentModule {
    @Provides
    fun providesDetailViewModel(
        itemImagesUseCase: GetItemImagesUseCase,
        itemDescriptionUseCase: GetItemDescriptionUseCase
    ) = DetailViewModel(itemImagesUseCase, itemDescriptionUseCase)

    @Provides
    fun providesGetItemImagesUseCaseImp(repository: DetailRepository): GetItemImagesUseCase =
        GetItemImagesUseCaseImp(repository)

    @Provides
    fun providesGetItemDescriptionUseCaseImp(repository: DetailRepository): GetItemDescriptionUseCase =
        GetItemDescriptionUseCaseImp(repository)
}