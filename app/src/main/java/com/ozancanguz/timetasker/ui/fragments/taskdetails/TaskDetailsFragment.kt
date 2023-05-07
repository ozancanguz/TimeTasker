package com.ozancanguz.timetasker.ui.fragments.taskdetails

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ozancanguz.timetasker.databinding.FragmentTaskDetailsBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class TaskDetailsFragment : Fragment() {
    private var _binding: FragmentTaskDetailsBinding? = null

    private val binding get() = _binding!!


    private val args:TaskDetailsFragmentArgs by navArgs()


    private lateinit var timer: CountDownTimer

    private var timerDurationInMillis: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskDetailsBinding.inflate(inflater, container, false)


        setDetails()


        binding.seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                timerDurationInMillis = progress * 60 * 1000L
                updateTimerTextView()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // do nothing
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        binding.startButton.setOnClickListener {
           binding. startButton.isEnabled = false
            binding.stopButton.isEnabled = true

            timer = object : CountDownTimer(timerDurationInMillis, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    timerDurationInMillis = millisUntilFinished
                    updateTimerTextView()
                }

                override fun onFinish() {
                    binding.stopButton.isEnabled = false
                }
            }.start()
        }

        binding.stopButton.setOnClickListener {
            timer.cancel()
            binding.stopButton.isEnabled = false
           binding. startButton.isEnabled = true
            timerDurationInMillis = 0
            updateTimerTextView()
        }
        return binding.root
    }

    private fun setDetails() {
        val details=args.currentTaskk.task
        Log.d("deneme",details)
    }
    private fun updateTimerTextView() {
        val minutes = timerDurationInMillis / 1000 / 60
        val seconds = (timerDurationInMillis / 1000) % 60
        binding.timerTextview.text = "%02d:%02d".format(minutes, seconds)
    }



}