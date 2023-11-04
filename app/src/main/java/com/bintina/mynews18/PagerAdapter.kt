package com.bintina.mynews18

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bintina.mynews18.popular.controller.PopularNewsFragment
import com.bintina.mynews18.stories.arts.controller.ArtStoriesFragment
import com.bintina.mynews18.stories.business.controller.BusinessStoriesFragment
import com.bintina.mynews18.stories.science.controller.ScienceStoriesFragment
import com.bintina.mynews18.stories.top.controller.TopStoriesFragment

class PagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> TopStoriesFragment()
            1 -> PopularNewsFragment()
            2 -> BusinessStoriesFragment()
            3 -> ArtStoriesFragment()
            4 -> ScienceStoriesFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }

}