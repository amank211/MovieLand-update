package com.pixelpatch.movieland.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pixelpatch.movieland.R
import com.pixelpatch.movieland.datamodels.trending.TrendingMovieResponseWeekly
import com.pixelpatch.movieland.datamodels.trending.TrendingTVResponseWeekly
import com.pixelpatch.movieland.ui.adapter.TrendingAllAdapter
import com.pixelpatch.movieland.viewmodel.MovieViewModel

class Discover : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private val movieModel = MovieViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.dicover_fragment, container, false)

        val popularTVLivedata = MutableLiveData<TrendingTVResponseWeekly>()
        popularTVLivedata.observe(viewLifecycleOwner, Observer {
            val trendingTVAdapter = context?.let { it1 -> TrendingAllAdapter(it1, it.results, movieModel) }
            v.findViewById<RecyclerView>(R.id.trending).layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            v.findViewById<RecyclerView>(R.id.trending).adapter = trendingTVAdapter
        })
        movieModel.queryDiscoverTV(popularTVLivedata)

        val discTVLivedata = MutableLiveData<TrendingMovieResponseWeekly>()
        discTVLivedata.observe(viewLifecycleOwner, Observer {
            val trendingTVAdapter = context?.let { it1 -> TrendingAllAdapter(it1, it.results, movieModel) }
            v.findViewById<RecyclerView>(R.id.upcoming).layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            v.findViewById<RecyclerView>(R.id.upcoming).adapter = trendingTVAdapter
        })
        movieModel.queryDiscoverMovie(discTVLivedata)
        return v
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }
}