package com.example.late4class.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.late4class.classSchedule
import com.google.firebase.database.FirebaseDatabase

class scheduleAdapter (val mCtx: Context, val layoutId:Int, val scheduleList:List<classSchedule>)
    :ArrayAdapter<classSchedule>(mCtx,layoutId,scheduleList){



}