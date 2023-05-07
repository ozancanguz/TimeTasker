package com.ozancanguz.timetasker.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tasktable")
@Parcelize
data class Task(

    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var task:String
):Parcelable
