package com.aliceresponde.mercadoco.di

import android.app.Application
import android.content.Context
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
class AppModule {

    @Provides
    @Singleton
    fun provideNetworkConnectionInterceptor(application: Application): Interceptor =
        NetworkConnectionInterceptor(application)

    @Provides
    @Singleton
    fun provideMercadoApiService(interceptor: Interceptor) =
        MercadoApiService.invoke(interceptor)
}