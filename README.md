# CIELO-ECOMMERCE-OAUTH-ANDROID [![Status](https://travis-ci.com/DeveloperCielo/cielo-ecommerce-oauth-android.svg?branch=master)](https://travis-ci.com/DeveloperCielo/cielo-ecommerce-oauth-android) [![Download](https://api.bintray.com/packages/braspag/cieloecommerceoauth/cieloecommerceoauth/images/download.svg?version=1.0.0) ](https://bintray.com/braspag/cieloecommerceoauth/cieloecommerceoauth/1.0.0/link)

Android Library para auxiliar na obtenção do AccessToken para OAuth Cielo

## Requisitos

- Android Studio version 3.1+ com Android SDK Platform version 5.0+ (API level 21+)

## Instalação

- Será necessário adicionar a seguinte dependência ao **build.gradle** do seu app module:

```kotlin
    ìmplementation 'br.com.braspag:cieloecommerceoauth:1.0.0'
```

- Ou baixar manualmente através da versão mais atual encontrada em [releases](https://github.com/DeveloperCielo/cielo-ecommerce-oauth-android/releases)

## Modo de uso

### Configuração

Para iniciar o cliente do SDK será necessário informar client id e client secret:

```kotlin
val client = HttpCredentialsClient(
    Environment.SANDBOX,
    "<YOUR-CLIENT-ID>",
    "<YOUR-CLIENT-SECRET>"
)
```

### Utilização

```kotlin
client.getOAuthCredentials({
    // onSuccessCallback
    textView.text = it.token
},{
    // onError
    textView.text = it
})
```
