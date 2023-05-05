package com.ozancanguz.timetasker.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasklist_table")
data class Task(

    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var task:String
)
