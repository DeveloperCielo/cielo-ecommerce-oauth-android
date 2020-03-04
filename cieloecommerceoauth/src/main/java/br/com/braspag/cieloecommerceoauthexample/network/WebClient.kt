package br.com.braspag.cieloecommerceoauthexample.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class WebClient(apiUrl: String) {

    private val retrofit = Builder()
        .baseUrl(apiUrl)
        .addConverterFactory(GsonConverterFactory.create())

    private var httpClient: OkHttpClient.Builder = OkHttpClient().newBuilder()

    fun <T> createService(service: Class<T>): T {

        val client = httpClient
            .connectTimeout(45, TimeUnit.SECONDS)
            .readTimeout(45, TimeUnit.SECONDS)
            .writeTimeout(45, TimeUnit.SECONDS)
            .build()

        return retrofit
            .client(client)
            .build()
            .create(service)
    }
}