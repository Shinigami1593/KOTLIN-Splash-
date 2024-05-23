package com.example.splashandbuttonnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.splashandbuttonnavigation.databinding.FragmentDestination2Binding

class DestinationFragment : Fragment() {
    lateinit var binding : FragmentDestination2Binding

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDestination2Binding.inflate(inflater,container,false)
        var a = arguments?.getInt("first").toString().toInt()
        var b = arguments?.getInt("second").toString().toInt()

        var result = a+b

        binding.resultText.text = "The sum of $a and $b is $result"

        return binding.root
    }
}