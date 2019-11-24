package com.example.late4class

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.late4class.Dashboard_pack.Dashboard
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_welcome.*

class welcome : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        auth = FirebaseAuth.getInstance()

        signup_text_button.setOnClickListener {
            startActivity(Intent(this, register::class.java))
            finish()
        }

        welcome_login_button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)

    }

    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null){
            startActivity(Intent(this,Dashboard::class.java))
            finish()
        } else {
            Toast.makeText(
                baseContext, "Login failed",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}