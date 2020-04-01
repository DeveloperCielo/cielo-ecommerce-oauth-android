package br.com.braspag.cieloecommerceoauth.network

import br.com.braspag.cieloecommerceoauth.BuildConfig
import br.com.braspag.cieloecommerceoauth.extensions.toStatusCode
import br.com.braspag.cieloecommerceoauth.model.AccessToken
import br.com.braspag.cieloecommerceoauth.model.AuthClientModel
import okhttp3.Credentials
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Calendar

class HttpCredentialsClient(
    private val environment: Environment,
    private val clientId: String,
    private val clientSecret: String
) : CredentialsClient {

    override fun getOAuthCredentials(
        onSuccessCallback: (model: AccessToken) -> Unit,
        onError: (error: String) -> Unit
    ) {
        val authorizationHeaderValue = Credentials.basic(clientId, clientSecret)

        val webClient = WebClient(
            setEnvironment(environment)
        )
        val call = webClient.createService(OAuthApi::class.java)
            .getTokenOAuth(authorizationHeaderValue, "client_credentials")

        call.enqueue(object : Callback<AuthClientModel> {
            override fun onFailure(call: Call<AuthClientModel>, t: Throwable) {
                t.message?.let { onError.invoke(it) }
            }

            override fun onResponse(
                call: Call<AuthClientModel>,
                response: Response<AuthClientModel>
            ) {
                if (response.isSuccessful) {
                    response.body()?.apply {
                        onSuccessCallback(
                            AccessToken(
                                accessToken,
                                expiresIn,
                                Calendar.getInstance().time
                            )
                        )
                    }
                    if (response.body() == null)
                        onError.invoke("The response object is null.")
                } else {
                    onError.invoke("error ${response.code()} ${response.code().toStatusCode()}")
                }
            }
        })
    }

    private fun setEnvironment(environment: Environment): String {
        return if (environment == Environment.SANDBOX)
            BuildConfig.URL_OAUTH_SANDBOX
        else
            BuildConfig.URL_OAUTH_PRODUCTION
    }
}