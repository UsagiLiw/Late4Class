package com.example.late4class

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dashboard.*
import android.widget.Toast

class Dashboard : AppCompatActivity() {

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
