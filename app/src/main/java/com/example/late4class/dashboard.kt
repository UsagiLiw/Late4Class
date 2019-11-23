package com.example.late4class

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dashboard.*
import android.widget.Toast
import com.google.firebase.FirebaseError
import com.google.firebase.database.*

class Dashboard : AppCompatActivity() {

    private lateinit var firebase: DatabaseReference

    override fun onStart() {
        super.onStart()

        firebase = FirebaseDatabase.getInstance().reference
        val uName = firebase.child("testText")
        uName.addListenerForSingleValueEvent(object : ValueEventListener {
            override
            fun onCancelled(error: FirebaseError?) {
                println(error!!.message)
            }

            override fun onDataChange(snapshot: DataSnapshot?) {
                val children = snapshot!!.children
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        button.setOnClickListener{
            Toast.makeText(this, "Activity not yet implement", Toast.LENGTH_LONG).show()
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
            Toast.makeText(this, "Activity not yet implement", Toast.LENGTH_LONG).show()
        }

    }
}
