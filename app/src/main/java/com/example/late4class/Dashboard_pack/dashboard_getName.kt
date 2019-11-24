package com.example.late4class.Dashboard_pack

import com.google.firebase.database.DataSnapshot
import java.lang.Exception

class dashboard_getName (snapshot: DataSnapshot){

    lateinit var id: String
    lateinit var fname: String
    lateinit var lname: String
    lateinit var email: String

    init {
        try {
            val data: HashMap<String, Any> = snapshot.value as HashMap<String, Any>
            id = snapshot.key ?: ""
            fname = data["fName"] as String
            lname = data["lName"] as String
            email = data["eMail"] as String
        }catch(e: Exception) {
            e.printStackTrace()
        }
    }
}