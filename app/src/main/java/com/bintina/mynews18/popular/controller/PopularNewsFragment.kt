package com.bintina.mynews18.popular.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.lifecycleScope
import com.bintina.mynews18.data.DataSource
import com.bintina.mynews18.databinding.FragmentPopularNewsBinding
import com.bintina.mynews18.popular.adapter.Adapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PopularNewsFragment: Fragment() {

    lateinit var adapter: Adapter

    private var _binding: FragmentPopularNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPopularNewsBinding.inflate(inflater,container, false)
        initializeList()

        lifecycleScope.launch(Dispatchers.IO){
            val result = DataSource.loadPopularNews()
            withContext(Dispatchers.Main){
                if (result != null){
                    adapter.popularNewsList = result
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
        binding.popularRecycler.adapter = adapter
    }
}