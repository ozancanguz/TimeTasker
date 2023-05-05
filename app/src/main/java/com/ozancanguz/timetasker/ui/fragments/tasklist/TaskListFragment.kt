package com.ozancanguz.timetasker.ui.fragments.tasklist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ozancanguz.timetasker.R
import com.ozancanguz.timetasker.databinding.FragmentTaskListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class TaskListFragment : Fragment() {

    private var _binding: FragmentTaskListBinding? = null

    private val binding get() = _binding!!




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTaskListBinding.inflate(inflater, container, false)


        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_taskListFragment_to_taskFragment)
        }

        return binding.root

    }


}