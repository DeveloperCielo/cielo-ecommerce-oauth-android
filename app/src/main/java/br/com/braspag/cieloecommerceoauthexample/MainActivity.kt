package br.com.braspag.cieloecommerceoauthexample

import android.app.Activity
import android.os.Bundle
import br.com.braspag.cieloecommerceoauthexample.network.Environment
import br.com.braspag.cieloecommerceoauthexample.network.HttpCredentialsClient
import kotlinx.android.synthetic.main.activity_main.textView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val client = HttpCredentialsClient(
            Environment.SANDBOX,
            "df66638b-3ef4-421f-a18e-e20dea38d97d",
            "q13XZ48haFg4EhAS2cjcoyX7OzRECYysY6T9TJLmKNM="
        )

        client.getOAuthCredentials({
            textView.text = it.token
        },{
            textView.text = it
        })
    }
}