package com.bintina.mynews18.stories.science.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bintina.mynews18.data.DataSource
import com.bintina.mynews18.databinding.FragmentScienceStoriesBinding
import com.bintina.mynews18.stories.adapter.Adapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ScienceStoriesFragment: Fragment() {

    lateinit var adapter: Adapter

    private var _binding: FragmentScienceStoriesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScienceStoriesBinding.inflate(inflater, container, false)
        initializeList()

        lifecycleScope.launch(Dispatchers.IO){
            val result = DataSource.loadScienceStories()
            withContext(Dispatchers.Main){
                if (result != null){
                    adapter.newsList = result
                    adapter.notifyDataSetChanged()
                }
            }
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initializeList(){
        adapter = Adapter()
        binding.scienceRecycler.adapter = adapter
    }
}