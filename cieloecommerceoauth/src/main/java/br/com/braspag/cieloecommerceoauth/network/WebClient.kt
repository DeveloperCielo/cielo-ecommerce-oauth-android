package br.com.braspag.cieloecommerceoauth.network

import br.com.braspag.cieloecommerceoauth.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class WebClient(apiUrl: String) {

    private val retrofit = Builder()
        .baseUrl(apiUrl)
        .addConverterFactory(GsonConverterFactory.create())

    private var httpClient: OkHttpClient.Builder = OkHttpClient().newBuilder()

    fun <T> createService(service: Class<T>): T {

        val logging = HttpLoggingInterceptor()
        logging.level =
            if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE

        val client = httpClient
            .addInterceptor(logging)
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