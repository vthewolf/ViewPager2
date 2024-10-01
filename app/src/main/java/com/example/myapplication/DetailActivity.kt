package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityDetailBinding
import com.google.android.material.tabs.TabLayoutMediator

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var recyclerView: RecyclerView

    private val customers = listOf(
        Customer(
            "Víctor Santiago",
            "https://upload.wikimedia.org/wikipedia/commons/d/d7/Commons_QR_code.png"),
        Customer(
            "Lucía Carbajo",
            "https://boofcv.org/images/thumb/b/bb/Example_render_microqr.png/400px-Example_render_microqr.png"),
        Customer(
            "Nova Santiago Carbajo",
            "https://raw.githubusercontent.com/kozakdenys/qr-code-styling/master/src/assets/qr_code_example.png")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupUi()

    }

    private fun setupUi() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.adapter = CardAdapter(customers)
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

}