package com.ozancanguz.timetasker.data.db

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ozancanguz.timetasker.data.model.Task

class TypeConverter {

    var gson = Gson()

    @androidx.room.TypeConverter
    fun TaskListToString(expense:List<Task>): String {
        return gson.toJson(expense)
    }

    @androidx.room.TypeConverter
    fun stringToTaskList(data: String): List<Task> {
        val listType = object : TypeToken<List<Task>>() {}.type
        return gson.fromJson(data, listType)
    }
}