# OAUTH-CIELO

# Requisitos

- Android Studio version 3.1+ com Android SDK Platform version 4.4+ (API level 19+)

# Instalação

- Será necessário adicionar a seguinte dependência ao *build.gradle* do seu projeto:

``ìmplementation 'br.com.braspag:cieloecommerceoauth:1.0.0'``

# Modo de uso

## Configuração

Para iniciar o cliente do SDK será necessário informar cliente id e cliente secret:
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
    textView.text = it.token
},{
    textView.text = it
})
```
