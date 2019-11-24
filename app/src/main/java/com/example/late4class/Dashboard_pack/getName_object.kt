package com.example.late4class.Dashboard_pack

import android.util.Log
import com.google.firebase.database.*
import java.util.*
import kotlin.collections.ArrayList

object getName_object: Observable() {

    private var mValueDataListener: ValueEventListener? = null
    private var mStringList: ArrayList<dashboard_getName>? = ArrayList()

    private fun getDatabaseRef(): DatabaseReference?{
        return FirebaseDatabase.getInstance().reference.child("testText")
    }

    init {
        if (mValueDataListener != null) {
            getDatabaseRef()?.removeEventListener(mValueDataListener!!)
        }
        mValueDataListener = null
        Log.i("testText", "data init line 26")

        mValueDataListener = object: ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                try {
                    Log.i("testText","data updated line 29")
                    val data: ArrayList<dashboard_getName> = ArrayList()
                    if (dataSnapshot != null){
                        for (snapshot: DataSnapshot in dataSnapshot.children) {
                            try {
                                data.add(dashboard_getName(snapshot))
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                        mStringList = data
                        Log.i("stringModel","data updated")
                        setChanged()
                        notifyObservers()
                    }
                }catch (e: Exception){
                    e.printStackTrace()
                }
            }

            override fun onCancelled(p0: DatabaseError) {
                if(p0 != null){
                    Log.i("stringModel","line 51 data update cancelled")
                }
            }

        }
       getDatabaseRef()?.addValueEventListener(mValueDataListener as ValueEventListener)
    }
}

