package com.ozancanguz.timetasker.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ozancanguz.timetasker.data.model.Task


@Dao
interface TaskDao {

    @Query("select * from tasklist_table order by id asc")
    fun getAllTaskList(): LiveData<List<Task>>

    @Insert
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)
}