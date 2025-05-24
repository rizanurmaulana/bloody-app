package com.example.bloody_app.ui.schedule

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bloody_app.R
import com.example.bloody_app.databinding.FragmentScheduleBinding
import com.example.bloody_app.model.listSchedule

class ScheduleFragment : Fragment() {

    private var _binding: FragmentScheduleBinding? = null
    private val binding get() = _binding!!

    private lateinit var scheduleAdapter: ScheduleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentScheduleBinding.inflate(inflater, container, false)

        binding.topAppBar.title = "Event Donor Darah"
        binding.topAppBar.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.searchEvent.setOnClickListener {
            // Tambahkan logika pencarian di sini
        }

        scheduleAdapter = ScheduleAdapter(listSchedule) { selectedSchedule ->
            val bundle = Bundle().apply {
                putParcelable("schedule", selectedSchedule)
            }
            findNavController().navigate(R.id.scheduleDetailFragment, bundle)
        }

        binding.rvScheduleList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = scheduleAdapter
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}