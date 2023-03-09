package com.kk.memechallengexml.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.kk.memechallengexml.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()
    private val adapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeRecyclerAndAdapter()
        observer()
    }

    private fun initializeRecyclerAndAdapter() {
        binding.rvMain.adapter = adapter
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.SwipeRefresh.setOnRefreshListener {
            binding.SwipeRefresh.isRefreshing = false
            viewModel.getMemes()
        }
    }

    private fun observer() {
        viewModel.memeList.observe(this){
            adapter.submitList(it)
        }
        viewModel.error.observe(this){
            Toast.makeText(applicationContext, it, Toast.LENGTH_LONG).show()
        }
    }
}