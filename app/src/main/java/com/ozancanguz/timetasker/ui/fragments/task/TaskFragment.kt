package com.ozancanguz.timetasker.ui.fragments.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.ozancanguz.timetasker.R
import com.ozancanguz.timetasker.data.model.Task
import com.ozancanguz.timetasker.databinding.FragmentTaskBinding
import com.ozancanguz.timetasker.ui.fragments.tasklist.TaskListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class TaskFragment : Fragment() {

    private var _binding: FragmentTaskBinding? = null

    private val binding get() = _binding!!

    private val taskListViewModel:TaskListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTaskBinding.inflate(inflater, container, false)



        // insert to db
        insertTaskToDb()

        return binding.root

    }

    private fun insertTaskToDb() {
        binding.addtoDb.setOnClickListener {
            val task=binding.taskEditText.text.toString()
            val toTask= Task(0,task)
            taskListViewModel.insertTask(toTask)
            Toast.makeText(requireContext(),"Task Added",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_taskFragment_to_taskListFragment)

        }
    }

}