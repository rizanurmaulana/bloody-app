package com.example.bloody_app.ui.jadwal

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bloody_app.R
import com.example.bloody_app.databinding.FragmentJadwalBinding
import com.example.bloody_app.model.JadwalDonor
import com.example.bloody_app.model.listJadwal

class JadwalFragment : Fragment() {

    private var _binding: FragmentJadwalBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerJadwal: RecyclerView
    private lateinit var jadwalAdapter: JadwalAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentJadwalBinding.inflate(inflater, container, false)

        binding.topAppBar.title = "Event Donor Darah"
        binding.topAppBar.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.searchEvent.setOnClickListener {
            // Tambahkan logika pencarian di sini
        }

        recyclerJadwal = binding.recyclerJadwal

        jadwalAdapter = JadwalAdapter(listJadwal)

        recyclerJadwal.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = jadwalAdapter
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}