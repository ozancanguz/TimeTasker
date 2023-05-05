package com.ozancanguz.timetasker.data.local

import androidx.lifecycle.LiveData
import com.ozancanguz.timetasker.data.db.TaskDao
import com.ozancanguz.timetasker.data.model.Task
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val taskDao: TaskDao){


    fun getAllTaskList(): LiveData<List<Task>> {
        return taskDao.getAllTaskList()
    }

    suspend fun insertTask(task: Task){
        return taskDao.insertTask(task)
    }

    suspend fun deleteTask(task: Task){
        return taskDao.deleteTask(task)
    }

}