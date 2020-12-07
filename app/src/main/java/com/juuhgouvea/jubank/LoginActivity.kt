package com.juuhgouvea.jubank

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.juuhgouvea.jubank.database.AppDatabase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loggedUserId = getPreferences(Context.MODE_PRIVATE)
                .getLong("logged_user_id", -1).toInt();

        if(loggedUserId !== -1) {
            goToMain();
        }

        btnLogin.setOnClickListener { loginHandler(inputUsername.text.toString(), inputPassword.text.toString()) }
        linkRegister.setOnClickListener { goToRegister() }
    }

    private fun loginHandler(username: String = "", password: String = "") {
        val userDao = MainApplication.appContext?.let { AppDatabase.getDatabase(it) }?.userDao()
        val user = userDao?.findByUsernameAndPassword(username, password);

        if(user === null) {
            Toast.makeText(this, R.string.invalid_user, Toast.LENGTH_SHORT)
                .show();
            return;
        }

        user.id?.let {
            this.getPreferences(Context.MODE_PRIVATE)
                .edit()
                .putLong("logged_user_id", it.toLong())
                .commit()
        };
        goToMain();
    }

    private fun goToRegister() {
        var intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun goToMain() {
        var intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        };

        startActivity(intent);
    }
}