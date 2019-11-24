package com.example.late4class

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

        button_login.setOnClickListener {
            doLogin()
            }
        }

    private fun doLogin(){
        if(login_email.text.toString().isEmpty()){
            login_email.error = "Please enter email"
            login_email.requestFocus()
            return
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(login_email.text.toString()).matches()){
            login_email.error = "Please enter valid email"
            login_email.requestFocus()
            return
        }

        if(login_password.text.toString().isEmpty()){
            login_password.error = "Please enter password"
            login_password.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(login_email.text.toString(), login_password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    Toast.makeText(baseContext, "Login failed, please try again.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null) {
            updateUI(currentUser)
        }
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null){
            startActivity(Intent(this,dashboard::class.java))
            finish()
        } else {
            Toast.makeText(
                baseContext, "Login failed",
            Toast.LENGTH_SHORT
            ).show()
        }
    }
}
