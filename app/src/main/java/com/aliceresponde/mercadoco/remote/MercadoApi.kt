package com.aliceresponde.mercadoco.remote

import com.aliceresponde.mercadoco.remote.response.ItemDescriptionResponse
import com.aliceresponde.mercadoco.remote.response.ItemResponse
import com.aliceresponde.mercadoco.remote.response.ItemsResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MercadoApi {
    companion object {
        private const val BASE_URL = "https://api.mercadolibre.com/"
        private const val CO = "MCO"

        operator fun invoke(interceptor: NetworkConnectionInterceptor): MercadoApi {
            val logInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(logInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MercadoApi::class.java)
        }
    }

    // https://api.mercadolibre.com//sites/MLC/search?q=alicia
    @GET("sites/$CO/search")
    suspend fun findItemBy(@Query("q") keyWords: String): Response<ItemsResponse>

    // https://api.mercadolibre.com/items/MLC489435759
    @GET("items/{item_id}")
    suspend fun getGetItem(@Path("{item_id}") id: String): Response<ItemResponse>

    // https://api.mercadolibre.com/items/MCO545313621/description
    @GET("items/{item_id}/description")
    suspend fun getItemDescription(@Path("item_id") id: String): Response<ItemDescriptionResponse>
}