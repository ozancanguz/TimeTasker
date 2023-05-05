package com.ozancanguz.timetasker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.timetasker.R
import com.ozancanguz.timetasker.data.model.Task
import com.ozancanguz.timetasker.databinding.TaskRowLayoutBinding

class TaskListAdapter() :
    RecyclerView.Adapter<TaskListAdapter.TaskListViewHolder>() {

    inner class TaskListViewHolder(val binding: TaskRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var taskList= emptyList<Task>()

    fun setTaskList(taskList:List<Task>){
        this.taskList=taskList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        val binding =
            TaskRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskListViewHolder(binding)
    }

    override fun getItemCount() = taskList.size

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        val currentTask = taskList[position]

        holder.binding.taskTextview.text = currentTask.task
    }
}
