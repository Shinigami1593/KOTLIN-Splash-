package com.example.splashandbuttonnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.splashandbuttonnavigation.databinding.FragmentDestinationNewBinding

// TODO: Rename parameter arguments, choose names that match


class DestinationNewFragment : Fragment() {
    lateinit var binding :FragmentDestinationNewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDestinationNewBinding.inflate(inflater,container,false)

        binding.sendData2.setOnClickListener{
            var name: String = binding.newDataName.text.toString()
            var age:Int = binding.newDataAge.text.toString().toInt()

            var baseActivity =activity as BaseActivity

            baseActivity.setData(name,age)

        }
        return binding.root
    }

}