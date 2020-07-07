package com.aliceresponde.mercadoco.ui

import android.app.Application
import com.aliceresponde.mercadoco.data.repository.ItemsRepositoryImp
import com.aliceresponde.mercadoco.usecase.SearchItemUC
import com.aliceresponde.mercadoco.data.remote.MercadoApiService
import com.aliceresponde.mercadoco.data.remote.NetworkConnectionInterceptor
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MercadoApp : Application() {
    private lateinit var searchUseCaseUC: SearchItemUC

    override fun onCreate() {
        super.onCreate()
        //todo change after add DI
        searchUseCaseUC =
            SearchItemUC(ItemsRepositoryImp(MercadoApiService.invoke(NetworkConnectionInterceptor(this))))
    }

    fun provideSearchUseCase() = searchUseCaseUC
}