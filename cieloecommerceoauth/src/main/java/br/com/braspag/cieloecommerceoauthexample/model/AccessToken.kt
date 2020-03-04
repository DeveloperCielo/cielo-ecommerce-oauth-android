package br.com.braspag.cieloecommerceoauthexample.model

import java.util.Calendar
import java.util.Date

data class AccessToken(
    val token: String,
    val expiresIn: Int,
    val issuedAt: Date
) {
    fun stillValid(): Boolean {
        val issMs = issuedAt.time
        val nowMs = Calendar.getInstance().time.time
        val expMs = (issMs + expiresIn * 1000)
        return nowMs in issMs until expMs
    }
}