package com.example.late4class.Class_module

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.late4class.Model.classModel
import com.example.late4class.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class ClassList : AppCompatActivity() {
    private val TAG = "Class"
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var dataReference: DatabaseReference
    private lateinit var response_data: MutableList<classModel>
    private lateinit var recyclerView: RecyclerView
    private lateinit var currentUser: String
    private var classAdapter: classAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_list)

        currentUser = FirebaseAuth.getInstance().currentUser!!.uid
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.setLayoutManager(GridLayoutManager(this,2))
        firebaseDatabase = FirebaseDatabase.getInstance()
        dataReference = firebaseDatabase!!.getReference("users/$currentUser")
        response_data = mutableListOf()

        classAdapter = classAdapter(response_data as ArrayList<classModel>)
        recyclerView!!.setAdapter(classAdapter)
        bindingData()
    }

    private fun bindingData() {
        dataReference!!.addChildEventListener(object : ChildEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {

            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {

            }

            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                response_data!!.add(p0.getValue(classModel::class.java)!!)
                classAdapter!!.notifyDataSetChanged()
            }
            override fun onChildRemoved(p0: DataSnapshot) {

            }
        })
    }
}
