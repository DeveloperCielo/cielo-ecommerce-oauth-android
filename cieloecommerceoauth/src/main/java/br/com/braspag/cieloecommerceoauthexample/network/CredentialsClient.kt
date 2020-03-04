package br.com.braspag.cieloecommerceoauthexample.network

import br.com.braspag.cieloecommerceoauthexample.model.AccessToken

interface CredentialsClient {
    fun getOAuthCredentials(
        onSuccessCallback: (model: AccessToken) -> Unit,
        onError: (error: String) -> Unit
    )
}