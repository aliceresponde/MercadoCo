package com.aliceresponde.mercadoco.ui

import android.app.Application
import com.aliceresponde.mercadoco.data.repository.RepositoryImp
import com.aliceresponde.mercadoco.domain.SearchUseCase
import com.aliceresponde.mercadoco.domain.SearchUseCaseImp
import com.aliceresponde.mercadoco.remote.MercadoApi
import com.aliceresponde.mercadoco.remote.NetworkConnectionInterceptor

class MercadoApp : Application() {
    private lateinit var searchUseCase: SearchUseCase

    override fun onCreate() {
        super.onCreate()
        //todo change after add DI
        searchUseCase =
            SearchUseCaseImp(RepositoryImp(MercadoApi.invoke(NetworkConnectionInterceptor(this))))
    }

    fun provideSearchUseCase() = searchUseCase
}