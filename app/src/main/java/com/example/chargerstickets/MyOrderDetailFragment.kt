package com.example.chargerstickets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chargerstickets.databinding.FragmentMyOrderDetailBinding
import com.example.chargerstickets.databinding.FragmentScheduleBinding

class MyOrderDetailFragment : Fragment() {
    private var _binding: FragmentMyOrderDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyOrderDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}