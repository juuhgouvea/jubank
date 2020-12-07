package com.juuhgouvea.jubank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.juuhgouvea.jubank.database.AppDatabase
import com.juuhgouvea.jubank.models.User
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegister.setOnClickListener { registerHandler(
            inputUsername.text.toString(),
            inputPassword.text.toString(),
            inputConfirmPassword.text.toString()
        ) }
    }

    private fun registerHandler(
        username: String = "",
        password: String = "",
        confirmPassword: String = ""
    ) {
        if(username.equals("") || password.equals("") || !password.equals(confirmPassword)) {
            return;
        }

        val userDao = MainApplication.appContext?.let { AppDatabase.getDatabase(it) }?.userDao();


        val newUser = User(username, password);
        newUser.id = userDao?.insert(newUser);

        var intent = Intent(this, LoginActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        startActivity(intent);
    }
}