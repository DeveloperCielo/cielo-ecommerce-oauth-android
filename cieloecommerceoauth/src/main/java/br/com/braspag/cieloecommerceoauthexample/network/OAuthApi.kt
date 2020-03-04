package br.com.braspag.cieloecommerceoauthexample.network

import br.com.braspag.cieloecommerceoauthexample.model.AuthClientModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface OAuthApi {
    @FormUrlEncoded
    @POST("v2/token")
    fun getTokenOAuth(
        @Header("authorization") authorization: String,
        @Field("grant_type") grant_type: String
    ): Call<AuthClientModel>
}