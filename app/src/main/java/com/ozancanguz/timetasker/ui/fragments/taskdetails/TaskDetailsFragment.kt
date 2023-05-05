package com.ozancanguz.timetasker.ui.fragments.taskdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozancanguz.timetasker.databinding.FragmentTaskDetailsBinding


class TaskDetailsFragment : Fragment() {
    private var _binding: FragmentTaskDetailsBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskDetailsBinding.inflate(inflater, container, false)


        return binding.root
    }


}