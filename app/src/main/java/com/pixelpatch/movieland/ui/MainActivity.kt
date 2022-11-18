package com.pixelpatch.movieland.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.material.tabs.TabLayout
import com.pixelpatch.movieland.R
import com.pixelpatch.movieland.datamodels.trending.*
import com.pixelpatch.movieland.ui.adapter.ViewPagerAdapter


class MainActivity : AppCompatActivity() {

    private var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById<ViewPager>(R.id.viewpager)
        addtabs()

        tabLayout = findViewById(R.id.tabs)
        (tabLayout as TabLayout).setupWithViewPager(viewPager)

        findViewById<View>(R.id.test).setOnClickListener{
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
        var adView = findViewById<View>(com.pixelpatch.movieland.R.id.ad_view) as AdView
        var adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }

    private fun addtabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFrag(Movie(), "Movies")
        adapter.addFrag(TV(), "TV")
        adapter.addFrag(Discover(), "Discover")
        adapter.addFrag(Celebrities(), "Celebs")
        viewPager?.adapter = adapter
    }

}