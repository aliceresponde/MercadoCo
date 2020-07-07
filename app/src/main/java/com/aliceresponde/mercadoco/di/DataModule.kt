package com.aliceresponde.mercadoco.di

import android.app.Application
import com.aliceresponde.mercadoco.data.remote.MercadoApiService
import com.aliceresponde.mercadoco.data.remote.NetworkConnectionInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideNetworkConnectionInterceptor(app: Application): Interceptor =
        NetworkConnectionInterceptor(app)

    @Provides
    @Singleton
    fun provideMercadoApiService(interceptor: NetworkConnectionInterceptor): MercadoApiService =
        MercadoApiService.invoke(interceptor)
}