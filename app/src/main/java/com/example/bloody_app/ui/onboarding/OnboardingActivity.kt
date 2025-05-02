package com.example.bloody_app.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.bloody_app.R
import com.example.bloody_app.ui.authentication.AuthActivity
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class OnboardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var textSkip: TextView
    private lateinit var buttonNext: Button
    private lateinit var dotsIndicator: DotsIndicator
    private lateinit var adapter: OnboardingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.viewPager)
        buttonNext = findViewById(R.id.buttonNext)
        dotsIndicator = findViewById(R.id.dots_indicator)
        textSkip = findViewById(R.id.textSkip)

        adapter = OnboardingAdapter(this)
        viewPager.adapter = adapter
        dotsIndicator.setViewPager2(viewPager)

        textSkip.setOnClickListener{
            finishOnboarding()
        }

        buttonNext.setOnClickListener {
            val nextItem = viewPager.currentItem + 1
            if (nextItem < adapter.itemCount) {
                viewPager.currentItem = nextItem
            } else {
                finishOnboarding()
            }
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == adapter.itemCount - 1) {
                    buttonNext.text = "Mulai"
                    textSkip.visibility = View.GONE
                } else {
                    buttonNext.text = "Selanjutnya"
                    textSkip.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun finishOnboarding() {
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }
}