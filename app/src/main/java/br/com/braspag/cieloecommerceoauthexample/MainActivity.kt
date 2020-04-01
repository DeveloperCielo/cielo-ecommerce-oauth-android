package br.com.braspag.cieloecommerceoauthexample

import android.app.Activity
import android.os.Bundle
import br.com.braspag.cieloecommerceoauth.network.Environment
import br.com.braspag.cieloecommerceoauth.network.HttpCredentialsClient
import kotlinx.android.synthetic.main.activity_main.textView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = HttpCredentialsClient(
            Environment.SANDBOX,
            "<YOUR-CLIENT-ID>",
            "<YOUR-CLIENT-SECRET>"
        )

        client.getOAuthCredentials({
            textView.text = it.token
        },{
            textView.text = it
        })
    }
}