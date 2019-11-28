package com.example.late4class

import com.google.firebase.database.Exclude

class userInfo {
    data class User(val fname:String = "",val lname:String = "", val email: String = "", @Exclude val uid: String? = "")
}