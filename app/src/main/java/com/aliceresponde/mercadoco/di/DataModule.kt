package com.aliceresponde.mercadoco.di

import com.aliceresponde.mercadoco.data.remote.MercadoApiService
import com.aliceresponde.mercadoco.data.repository.ItemsRepository
import com.aliceresponde.mercadoco.data.repository.ItemsRepositoryImp
import com.aliceresponde.mercadoco.data.repository.RemoteDataSource
import com.aliceresponde.mercadoco.data.repository.RetrofitDataSource
import com.aliceresponde.mercadoco.ui.detail.DetailRepository
import com.aliceresponde.mercadoco.ui.detail.DetailRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent


@Module
@InstallIn(ApplicationComponent::class)
class DataModule {

    @Provides
    fun providesDetailsRepository(remoteDataSource: RemoteDataSource): DetailRepository =
        DetailRepositoryImp(remoteDataSource)

    @Provides
    fun providesItemsRepository(remoteDataSource: RemoteDataSource): ItemsRepository =
        ItemsRepositoryImp(remoteDataSource)

    @Provides
    fun providesRemoteDataSource(service: MercadoApiService): RemoteDataSource =
        RetrofitDataSource(service)
}