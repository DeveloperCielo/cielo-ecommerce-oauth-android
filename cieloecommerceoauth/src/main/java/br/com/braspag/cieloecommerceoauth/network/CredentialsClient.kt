package br.com.braspag.cieloecommerceoauth.network

import br.com.braspag.cieloecommerceoauth.model.AccessToken

interface CredentialsClient {
    fun getOAuthCredentials(
        onSuccessCallback: (model: AccessToken) -> Unit,
        onError: (error: String) -> Unit
    )
}