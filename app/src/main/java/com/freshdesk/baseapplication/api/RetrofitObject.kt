package com.freshdesk.baseapplication.api

import com.freshdesk.baseapplication.utils.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    lateinit var request: Request
    private val retrofit by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client =
            OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
                request = chain.request()
                chain.proceed(request)
            }).addInterceptor(logging).build()

        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val api by lazy {
        retrofit.create(ApiService::class.java)
    }
}