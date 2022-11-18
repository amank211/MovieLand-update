package com.pixelpatch.movieland.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.pixelpatch.movieland.R
import com.pixelpatch.movieland.datamodels.search.MovieSearchResponse
import com.pixelpatch.movieland.datamodels.search.PersonSearchResponse
import com.pixelpatch.movieland.datamodels.search.TVSearchResponse
import com.pixelpatch.movieland.ui.adapter.TrendingAllAdapter
import com.pixelpatch.movieland.viewmodel.MovieViewModel

class SearchActivity : AppCompatActivity(), SearchView.OnQueryTextListener, OnTabSelectedListener {

    var movieViewModel = MovieViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        var adView = findViewById<View>(com.pixelpatch.movieland.R.id.ad_view) as AdView
        var adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }

    override fun onResume() {
        super.onResume()
        findViewById<SearchView>(R.id.search).setOnQueryTextListener(this)
        findViewById<TabLayout>(R.id.tabs).setOnTabSelectedListener(this)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {

        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null && newText.isNotEmpty()) {
            queryAPIs(newText)
        }
        return false
    }


    fun queryAPIs(query: String){
        var movieObserver = MutableLiveData<MovieSearchResponse>()
        movieObserver.observeForever(Observer {
            var castAdapter = TrendingAllAdapter(this, it.results, movieViewModel)
            findViewById<RecyclerView>(R.id.movies).layoutManager = GridLayoutManager(this, 3)
            findViewById<RecyclerView>(R.id.movies).adapter = castAdapter
        })
        movieViewModel.searchForMovies(query, movieObserver)

        var tvObserver = MutableLiveData<TVSearchResponse>()
        tvObserver.observeForever(Observer {
            var castAdapter = TrendingAllAdapter(this, it.results, movieViewModel)
            findViewById<RecyclerView>(R.id.tv_shows).layoutManager = GridLayoutManager(this, 3)
            findViewById<RecyclerView>(R.id.tv_shows).adapter = castAdapter
        })
        movieViewModel.searchForTVs(query, tvObserver)

        var personObserver = MutableLiveData<PersonSearchResponse>()
        personObserver.observeForever(Observer {
            var castAdapter = TrendingAllAdapter(this, it.results, movieViewModel)
            findViewById<RecyclerView>(R.id.person).layoutManager = GridLayoutManager(this, 3)
            findViewById<RecyclerView>(R.id.person).adapter = castAdapter
        })
        movieViewModel.searchForPerson(query, personObserver)
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        when(tab?.text){
            "MOVIES" -> {
                val scrollView: NestedScrollView = findViewById(R.id.scroller)
                val view: View = findViewById(R.id.movie_layout)
                scrollView.smoothScrollTo(view.x.toInt(), view.y.toInt())
            }
            "PERSONS" -> {
                val scrollView: NestedScrollView = findViewById(R.id.scroller)
                val view: View = findViewById(R.id.people_layout)
                scrollView.smoothScrollTo(view.x.toInt(), view.y.toInt())
            }
            "TV SHOWS" -> {
                val scrollView: NestedScrollView = findViewById(R.id.scroller)
                val view: View = findViewById(R.id.tv_layout)
                scrollView.smoothScrollTo(view.x.toInt(), view.y.toInt())
            }
        }
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }
}