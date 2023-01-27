package com.example.jeparadise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jeparadise.ui.ViewPagerAdapter
import com.example.jeparadise.databinding.ActivityMainBinding
import com.example.jeparadise.ui.culinary.CulinaryFragment
import com.example.jeparadise.ui.event.EventFragment
import com.example.jeparadise.ui.home.HomeFragment
import com.example.jeparadise.ui.place.PlaceFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        setupTab()
    }

    private fun setupTab() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), "")
        adapter.addFragment(PlaceFragment(), "")
        adapter.addFragment(EventFragment(), "")
        adapter.addFragment(CulinaryFragment(), "")

        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        binding.tabs.getTabAt(0)!!.setIcon(R.drawable.ic_home)
        binding.tabs.getTabAt(1)!!.setIcon(R.drawable.ic_location)
        binding.tabs.getTabAt(2)!!.setIcon(R.drawable.ic_calendar)
        binding.tabs.getTabAt(3)!!.setIcon(R.drawable.ic_culinary)
    }
}