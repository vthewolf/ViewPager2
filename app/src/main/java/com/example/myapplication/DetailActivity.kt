package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.ActivityDetailBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupSwipeRefreshLayout()
        setupViewPager()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun setupSwipeRefreshLayout() {
        binding.swipeRefreshLayout.setOnRefreshListener { refreshData() }
    }

    private fun setupViewPager() {
        val customers = listOf(
            Customer(
                "Víctor Santiago",
                "https://upload.wikimedia.org/wikipedia/commons/d/d7/Commons_QR_code.png",
                "https://cdn-icons-png.flaticon.com/512/3065/3065699.png"
            ),
            Customer(
                "Lucía Carbajo",
                "https://boofcv.org/images/thumb/b/bb/Example_render_microqr.png/400px-Example_render_microqr.png",
                "https://www.iconarchive.com/download/i141851/iconarchive/cute-animal/Cute-Monkey.1024.png"
            ),
            Customer(
                "Nova Santiago Carbajo",
                "https://raw.githubusercontent.com/kozakdenys/qr-code-styling/master/src/assets/qr_code_example.png",
                "https://cdn-icons-png.flaticon.com/128/427/427544.png"
            )
        )
        binding.viewPager.adapter = MyViewPagerAdapter(customers)
        binding.wormDotsIndicator.attachTo(binding.viewPager)
    }

    private fun refreshData() {
        lifecycleScope.launch {
            binding.swipeRefreshLayout.isRefreshing = true
            delay(2000)
            // TODO: Update data or UI here
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }
}