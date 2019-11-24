package com.example.late4class

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class register : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = FirebaseAuth.getInstance()

        btn_create_account.setOnClickListener {
            signUpUser()
        }
    }

    private fun signUpUser(){
        if(regis_email.text.toString().isEmpty()){
            regis_email.error = "Please enter email"
            regis_email.requestFocus()
            return
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(regis_email.text.toString()).matches()){
            regis_email.error = "Please enter valid email"
            regis_email.requestFocus()
            return
        }

        if(regis_password.text.toString().isEmpty()){
            regis_password.error = "Please enter password"
            regis_password.requestFocus()
            return
        }

        if(regis_password.text.toString() != regis_confirm_password.text.toString()){
            regis_confirm_password.error = "Confirm password not match with password"
            regis_confirm_password.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(regis_email.text.toString(), regis_password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(baseContext, "Sign up failed. Please wait and try again",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}
