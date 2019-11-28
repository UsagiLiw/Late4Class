package com.example.late4class.Dashboard_pack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dashboard.*
import android.widget.Toast
import com.example.late4class.*
import com.example.late4class.utils.ValueListenerAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


import java.util.*
import kotlin.collections.ArrayList

class Dashboard : AppCompatActivity(){

    private val TAG = "ProfileActivity"
    private lateinit var  mUser: userInfo.User
    private lateinit var  mAuth: FirebaseAuth
    private lateinit var  mDatabase: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        mAuth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance().reference

        fun currentUserReference(): DatabaseReference =
            mDatabase.child("users").child(mAuth.currentUser!!.uid)

        currentUserReference().addListenerForSingleValueEvent(
            ValueListenerAdapter{
                mUser = it.asUser()!!
                textUname.setText(mUser.fName)
            }
        )
        fun signingOut(){
            mAuth.signOut()
            mAuth.addAuthStateListener {
                if(mAuth.currentUser==null){
                    this.finish()
                }
            }
        }

        button.setOnClickListener {
            val intentTimetable = Intent(this, timeTable::class.java)
            startActivity(intentTimetable)
        }
        button2.setOnClickListener{
            Toast.makeText(this, "Activity not yet implement", Toast.LENGTH_LONG).show()
        }
        button3.setOnClickListener{
            Toast.makeText(this, "Activity not yet implement", Toast.LENGTH_LONG).show()
        }
        button4.setOnClickListener{
            Toast.makeText(this, "Activity not yet implement", Toast.LENGTH_LONG).show()
        }
        button5.setOnClickListener{
            Toast.makeText(this, "Activity not yet implement", Toast.LENGTH_LONG).show()
        }
        button6.setOnClickListener{
            Toast.makeText(this, "Activity not yet implement", Toast.LENGTH_LONG).show()
        }
        button7.setOnClickListener{
            signingOut()
            Toast.makeText(this, "User signing out", Toast.LENGTH_SHORT).show()
        }

    }

}
