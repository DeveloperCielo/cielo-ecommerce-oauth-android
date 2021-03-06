package br.com.braspag.cieloecommerceoauth.network

import br.com.braspag.cieloecommerceoauth.model.AuthClientModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface OAuthApi {
    @FormUrlEncoded
    @POST("oauth2/token")
    fun getTokenOAuth(
        @Header("authorization") authorization: String,
        @Header("x-sdk-version") x_sdk_version: String,
        @Field("grant_type") grant_type: String = "client_credentials"
    ): Call<AuthClientModel>
}