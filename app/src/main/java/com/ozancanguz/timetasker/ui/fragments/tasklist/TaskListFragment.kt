package com.ozancanguz.timetasker.ui.fragments.tasklist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.timetasker.R
import com.ozancanguz.timetasker.adapter.TaskListAdapter
import com.ozancanguz.timetasker.databinding.FragmentTaskListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class TaskListFragment : Fragment() {

    private var _binding: FragmentTaskListBinding? = null

    private val binding get() = _binding!!

    private val taskListViewModel:TaskListViewModel by viewModels()

    private val taskListAdapter=TaskListAdapter()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTaskListBinding.inflate(inflater, container, false)


        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_taskListFragment_to_taskFragment)
        }


        // setting up recyclerview
        setupRv()

        // observe tasklist live data and update ui
        observeLiveData()


        return binding.root

    }

    private fun observeLiveData() {
        taskListViewModel.taskList.observe(viewLifecycleOwner, Observer {
            taskListAdapter.setTaskList(it)
        })
    }

    private fun setupRv() {
        binding.taskListRv.layoutManager=LinearLayoutManager(requireContext())
        binding.taskListRv.adapter=taskListAdapter
    }




}