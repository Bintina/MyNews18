package com.bintina.mynews18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bintina.mynews18.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewPager()
    }

    private fun setupViewPager() {
        binding.pager.adapter = PagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = when (position){
                0 -> "Top Stories"
                1 -> "Popular"
                2 -> "Business"
                3 -> "Arts"
                4 -> "Science"
                else -> throw IllegalStateException("Unexpected position $position")
            }
        }
            .attach()
    }
}