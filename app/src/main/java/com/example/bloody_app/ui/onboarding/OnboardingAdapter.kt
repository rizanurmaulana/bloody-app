package com.example.bloody_app.ui.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.bloody_app.R

class OnboardingAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val layouts = listOf(
        R.layout.fragment_onboarding_1,
        R.layout.fragment_onboarding_2,
        R.layout.fragment_onboarding_3
    )

    override fun getItemCount(): Int = layouts.size

    override fun createFragment(position: Int): Fragment {
        return OnboardingFragment.newInstance(layouts[position])
    }
}
