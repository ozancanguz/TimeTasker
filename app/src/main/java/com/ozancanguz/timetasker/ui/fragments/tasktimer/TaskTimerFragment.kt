package com.ozancanguz.timetasker.ui.fragments.tasktimer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozancanguz.timetasker.databinding.FragmentTaskTimerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class TaskTimerFragment : Fragment() {
    private var _binding: FragmentTaskTimerBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTaskTimerBinding.inflate(inflater, container, false)



        return binding.root


    }


}