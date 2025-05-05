package com.example.bloody_app.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.bloody_app.R

class HomeFragment : Fragment() {

    private lateinit var bannerViewPager: ViewPager2
    private lateinit var bannerAdapter: BannerAdapter
    private lateinit var recyclerViewJadwal: RecyclerView
    private lateinit var jadwalAdapter: JadwalAdapter
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bannerViewPager = view.findViewById(R.id.bannerViewPager)

        val bannerList = listOf(
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3
        )

        bannerAdapter = BannerAdapter(bannerList)
        bannerViewPager.adapter = bannerAdapter

        autoSlideBanner()

        recyclerViewJadwal = view.findViewById(R.id.recyclerViewJadwal)

        val listJadwal = listOf(
            JadwalDonor("PMI Cirebon", "7 Mei 2025", "08.00 - 13.00", R.drawable.article1),
            JadwalDonor("Alun-Alun Majalengka", "10 Mei 2025", "09.00 - 12.00", R.drawable.article2),
            JadwalDonor("RS Indramayu", "12 Mei 2025", "08.30 - 11.00", R.drawable.article1)
        )

        jadwalAdapter = JadwalAdapter(listJadwal)

        recyclerViewJadwal.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = jadwalAdapter
        }
    }

    private fun autoSlideBanner() {
        val runnable = object : Runnable {
            override fun run() {
                val currentItem = bannerViewPager.currentItem
                val nextItem = if (currentItem < bannerAdapter.itemCount - 1) currentItem + 1 else 0
                bannerViewPager.setCurrentItem(nextItem, true)
                handler.postDelayed(this, 3000)
            }
        }
        handler.post(runnable)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacksAndMessages(null) // stop auto-slide ketika fragment dihancurkan
    }
}