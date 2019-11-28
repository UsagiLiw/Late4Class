package com.example.late4class

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class register : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance().reference

        btn_create_account.setOnClickListener {
            signUpUser()
        }
    }

    private fun signUpUser(){
        val fName = regis_firstName.text.toString()
        val lName =  regis_lastName.text.toString()
        val email = regis_email.text.toString()
        val password = regis_password.text.toString()
        val cpassword = regis_confirm_password.text.toString()

        if(email.isEmpty()){
            regis_email.error = "Please enter email"
            regis_email.requestFocus()
            return
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            regis_email.error = "Please enter valid email"
            regis_email.requestFocus()
            return
        }

        if(password.isEmpty()){
            regis_password.error = "Please enter password"
            regis_password.requestFocus()
            return
        }

        if(password != cpassword){
            regis_confirm_password.error = "Confirm password not match with password"
            regis_confirm_password.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if(it.isSuccessful){
                    val user = makeUser(fName, lName, email)
                    var reference = mDatabase.child("users").child(it.result!!.user.uid)
                    reference.setValue(user)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                startActivity(Intent(this,MainActivity::class.java))
                                finish()
                            } else {
                                Toast.makeText(baseContext, "Sign up failed. Please wait and try again",
                                    Toast.LENGTH_SHORT).show()
                            }
                        }

                } else {
                    Toast.makeText(baseContext, "Sign up failed. Please wait and try again",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun makeUser (fName : String, lName : String, email: String) : userInfo.User {
        return userInfo.User(fname = fName, lname = lName, email = email)
    }
}
