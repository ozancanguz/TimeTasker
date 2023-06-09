package com.ozancanguz.timetasker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.timetasker.data.model.Task
import com.ozancanguz.timetasker.databinding.TaskRowLayoutBinding
import com.ozancanguz.timetasker.ui.fragments.tasklist.TaskListFragmentDirections

class TaskListAdapter : RecyclerView.Adapter<TaskListAdapter.TaskListViewHolder>() {

    class TaskListViewHolder(private val binding: TaskRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        val taskTv: TextView = binding.taskTv
    }

    var taskList = emptyList<Task>()

    fun setTaskListItems(newTaskList: List<Task>) {
        this.taskList = newTaskList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        val binding = TaskRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        val currentTask = taskList[position]
        holder.taskTv.text = currentTask.task

        holder.itemView.setOnClickListener {
            val directions=TaskListFragmentDirections.actionTaskListFragmentToTaskDetailsFragment(currentTask)
            holder.itemView.findNavController().navigate(directions)
        }
    }
}
