package com.adityaamolbavadekar.metube.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.adityaamolbavadekar.metube.databinding.ActivityMainBinding
import com.adityaamolbavadekar.metube.ui.home.HomeRecyclerViewAdapter
import com.adityaamolbavadekar.metube.utils.DataGenerator
import com.google.android.material.navigation.NavigationBarView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: HomeRecyclerViewAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Firebase.auth.currentUser == null) {
            Toast.makeText(this, "Not authorized.", Toast.LENGTH_SHORT).show()
            return finishAndRemoveTask()
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val nav = (binding.bottomNav as NavigationBarView)
        nav.setOnItemReselectedListener { }
        nav.setOnItemSelectedListener { true }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        listAdapter = HomeRecyclerViewAdapter()
        linearLayoutManager = LinearLayoutManager(this)
        binding.list.apply {
            adapter = listAdapter
            layoutManager = linearLayoutManager
        }
        lifecycleScope.launch {
            DataGenerator.generatePosts(140)
                .also { listAdapter.submitList(it.toList()) }
        }
    }

}