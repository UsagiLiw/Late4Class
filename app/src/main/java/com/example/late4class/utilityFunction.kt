package com.example.late4class

import android.content.Context
import android.widget.Toast
import com.google.firebase.database.DataSnapshot

fun Context.showToast(text: String, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,text,duration).show()
}
fun DataSnapshot.asUser(): userInfo.User? =
    getValue(userInfo.User::class.java)?.copy(uid = key)