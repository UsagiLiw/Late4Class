package com.example.late4class

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.late4class.utils.scheduleAdapter
import com.google.firebase.database.*

class timeTable : AppCompatActivity() {

    lateinit var databaseRef : DatabaseReference
    lateinit var scheduleList : MutableList<classSchedule>
    lateinit var listview:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_table)


        setSupportActionBar(findViewById(R.id.toolbar))
        val actionBar = supportActionBar
        actionBar!!.title = "Timetable"

        scheduleList = mutableListOf()
        listview = findViewById(R.id.listViewDay)
        databaseRef = FirebaseDatabase.getInstance().getReference("schedules")

        databaseRef.addValueEventListener(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()){
                    scheduleList.clear()
                    for(e in p0.children){
                        val classTime = e.getValue(classSchedule::class.java)
                        scheduleList.add(classTime!!)
                    }
                    val adapter = scheduleAdapter(this@timeTable,R.layout.list_classtime,scheduleList)
                    listview.adapter = adapter
                }
            }
        })
    }
}
