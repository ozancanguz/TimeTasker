package com.ozancanguz.timetasker.ui.fragments.tasklist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ozancanguz.timetasker.data.model.Task
import com.ozancanguz.timetasker.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(var repository: Repository, application: Application):AndroidViewModel(application){


      // init task list live data
    var taskList:LiveData<List<Task>> = repository.local.getAllTaskList()


    // insert task
    fun insertTask(task: Task){
        viewModelScope.launch {
            repository.local.insertTask(task)
        }
    }

    // delete task
    fun deleteTask(task: Task){
        viewModelScope.launch {
            repository.local.deleteTask(task)
        }
    }

}