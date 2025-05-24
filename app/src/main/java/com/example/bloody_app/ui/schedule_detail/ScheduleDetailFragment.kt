package com.example.bloody_app.ui.schedule_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.core.content.ContextCompat
import com.example.bloody_app.R
import com.example.bloody_app.databinding.FragmentScheduleDetailBinding
import com.example.bloody_app.model.Schedule

class ScheduleDetailFragment : Fragment() {

    private var _binding: FragmentScheduleDetailBinding? = null
    private val binding get() = _binding!!

    private var scrollListener: ViewTreeObserver.OnScrollChangedListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScheduleDetailBinding.inflate(inflater, container, false)

        val schedule = arguments?.getParcelable<Schedule>("schedule")

        schedule?.let {
            binding.ivScheduleDetailImage.setImageResource(it.image)
            binding.tvScheduleDetailLocation.text = it.location
            binding.tvScheduleDetailDate.text = it.date
            binding.tvScheduleDetailTime.text = it.time
        }

        binding.topAppBar.title = "Detail Jadwal"
        binding.topAppBar.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        scrollListener = ViewTreeObserver.OnScrollChangedListener {
            _binding?.let { safeBinding ->
                val scrollY = safeBinding.scheduleScrollView.scrollY
                val context = safeBinding.root.context
                val color = if (scrollY > 100) R.color.color_primary else android.R.color.transparent
                safeBinding.topAppBar.setBackgroundColor(ContextCompat.getColor(context, color))
            }
        }

        binding.scheduleScrollView.viewTreeObserver.addOnScrollChangedListener(scrollListener)

        return binding.root
    }

    override fun onDestroyView() {
        scrollListener?.let {
            binding.scheduleScrollView.viewTreeObserver.removeOnScrollChangedListener(it)
        }
        scrollListener = null
        _binding = null
        super.onDestroyView()
    }
}

