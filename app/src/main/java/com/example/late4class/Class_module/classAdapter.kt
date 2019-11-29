package com.example.late4class.Class_module

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.late4class.Model.classModel
import com.example.late4class.R

class classAdapter(val classModelList: List<classModel>) : RecyclerView.Adapter<ViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.class_item,p0,false))
    }

    override fun getItemCount(): Int {
        return classModelList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val classModel = classModelList[p1]
        p0.classCode.text = classModel.classCode
        p0.className.text = classModel.className
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var classCode: TextView = itemView.findViewById(R.id.class_code)
    var className: TextView = itemView.findViewById(R.id.class_name)
}
