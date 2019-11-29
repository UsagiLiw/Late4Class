package com.example.late4class.Model

class classModel {
    var classCode: String? = null
    var className: String? = null
    var key : String? = null

    constructor()

    constructor(classCode: String?, className: String?, key: String?){
        this.classCode = classCode
        this.className = className
        this.key = key
    }

    fun toMap(): Map<String, Any> {
        val result = HashMap<String, Any>()
        result.put("classCode", classCode!!)
        result.put("className", className!!)
        result.put("key", key!!)
        return result
    }
}