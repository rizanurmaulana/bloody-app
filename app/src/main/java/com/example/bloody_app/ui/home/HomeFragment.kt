package com.example.bloody_app.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bloody_app.R
import com.example.bloody_app.databinding.FragmentHomeBinding
import com.example.bloody_app.databinding.ItemArticleBinding
import com.example.bloody_app.model.listArticles
import com.example.bloody_app.model.listScheduleLimit
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var bannerAdapter: BannerAdapter
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvSeeAllSchedule.setOnClickListener {
            val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation)
            bottomNav.selectedItemId = R.id.scheduleFragment
        }

        setupUser()
        setupBanner()
        setupSchedule()
        setupArticle()
    }

    @SuppressLint("SetTextI18n")
    private fun setupUser() {
        val userName = "Username"
        val daysRemaining = 5

        binding.tvGreeting.text = "Halo, $userName"
        binding.tvNextDonation.text = "Anda bisa donor lagi dalam $daysRemaining hari"
    }

    private fun setupBanner() {
        val bannerList = listOf(
            R.drawable.image_banner1,
            R.drawable.image_banner2,
            R.drawable.image_banner3
        )
        bannerAdapter = BannerAdapter(bannerList)
        binding.bannerViewPager.adapter = bannerAdapter
        autoSlideBanner()
    }

    private fun setupSchedule() {
        val scheduleCardAdapter = ScheduleCardAdapter(listScheduleLimit)
        binding.rvScheduleCard.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = scheduleCardAdapter
        }
    }

    private fun setupArticle() {
        for (article in listArticles) {
            val itemBinding = ItemArticleBinding.inflate(layoutInflater, binding.articleContainer, false)
            itemBinding.ivArticleImage.setImageResource(article.imageUrl)
            itemBinding.tvArticleTitle.text = article.title
            itemBinding.tvArticleDescription.text = article.description
            binding.articleContainer.addView(itemBinding.root)
        }
    }

    private fun autoSlideBanner() {
        val runnable = object : Runnable {
            override fun run() {
                val currentItem = binding.bannerViewPager.currentItem
                val nextItem = if (currentItem < bannerAdapter.itemCount - 1) currentItem + 1 else 0
                binding.bannerViewPager.setCurrentItem(nextItem, true)
                handler.postDelayed(this, 5000)
            }
        }
        handler.post(runnable)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacksAndMessages(null)
        _binding = null
    }
}
