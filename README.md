# CIELO-ECOMMERCE-OAUTH-ANDROID

# Requisitos

- Android Studio version 3.1+ com Android SDK Platform version 5.0+ (API level 21+)

# Instalação

- Será necessário adicionar a seguinte dependência ao *build.gradle* do seu projeto:

``ìmplementation 'br.com.braspag:cieloecommerceoauth:1.0.0'``

# Modo de uso

## Configuração

Para iniciar o cliente do SDK será necessário informar client id e client secret:
```kotlin
val client = HttpCredentialsClient(
    Environment.SANDBOX,
    "<YOUR-CLIENT-ID>",
    "<YOUR-CLIENT-SECRET>"
)
```

## Utilização
```kotlin
client.getOAuthCredentials({
    // onSuccessCallback
    textView.text = it.token
},{
    // onError
    textView.text = it
})
```
