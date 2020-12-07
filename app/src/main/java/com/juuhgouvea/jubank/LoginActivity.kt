package com.juuhgouvea.jubank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private val USERNAME = "julia";
    private val PASSWORD = "12345";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener { loginHandler(inputUsername.text.toString(), inputPassword.text.toString()) }
    }

    private fun loginHandler(username: String = "", password: String = "") {
        if(!username.toLowerCase().equals(USERNAME) or !password.equals(PASSWORD)) {
            Toast.makeText(this, R.string.invalid_user, Toast.LENGTH_SHORT)
                .show();
            return;
        }

        var intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        };
        startActivity(intent);
    }
}