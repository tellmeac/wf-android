package com.example.worldfactory.ui.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.worldfactory.databinding.FragmentThirdIntroBinding

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdIntroBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThirdIntroBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      //  binding.buttonSecond.setOnClickListener {
      //      findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
       // }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}