package com.example.chargerstickets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chargerstickets.databinding.FragmentScheduleBinding

class ScheduleFragment : Fragment() {
    private val sharedViewModel: BuyTicketsViewModel by activityViewModels {
        BuyTicketsViewModelFactory(
            (activity?.application as ChargersTicketsApplication).database.chargersTicketsDao()
        )
    }

    private var _binding: FragmentScheduleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScheduleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = GameListAdapter {
            val action = ScheduleFragmentDirections.actionScheduleFragmentToSeatsFragment(it.gameId)
            findNavController().navigate(action)
        }
        binding.gameRecyclerview.layoutManager = LinearLayoutManager(this.context)
        binding.gameRecyclerview.adapter = adapter

        //TODO: get argument from navigation, if true that came from home Fragment, reset all the values

        setUpChipListeners()

        sharedViewModel.getLastSelectedChip()?.let { id->
            binding.chipGroup.check(id)
        }

        sharedViewModel.games.observe(viewLifecycleOwner) { games->
            adapter.submitList(games)
        }

    }

    private fun setUpChipListeners() {
        binding.chipAll.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) sharedViewModel.filterGames("all")
        }
        binding.chipHome.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) sharedViewModel.filterGames("home")
        }
        binding.chipAway.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) sharedViewModel.filterGames("away")
        }
    }

    override fun onStop() {
        super.onStop()
        sharedViewModel.setLastSelectedChip(binding.chipGroup.checkedChipIds)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}