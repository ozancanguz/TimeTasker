package com.ozancanguz.timetasker.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ozancanguz.timetasker.data.model.Task


@Database(entities = [Task::class], version = 1,
 exportSchema = false,)

@TypeConverters(TypeConverter::class)
 abstract class TaskDatabase:RoomDatabase() {
    abstract fun taskDao():TaskDao


}