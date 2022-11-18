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
import com.pixelpatch.movieland.datamodels.trending.TrendingTVResponseWeekly
import com.pixelpatch.movieland.ui.adapter.TrendingAllAdapter
import com.pixelpatch.movieland.viewmodel.MovieViewModel

class TV : Fragment() {

    private val movieModel = MovieViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.tv_fragment, container, false)

        val trendingTVLivedata = MutableLiveData<TrendingTVResponseWeekly>()
        trendingTVLivedata.observe(viewLifecycleOwner, Observer {
            val trendingTVAdapter = context?.let { it1 -> TrendingAllAdapter(it1, it.results, movieModel) }
            v.findViewById<RecyclerView>(R.id.trending).layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            v.findViewById<RecyclerView>(R.id.trending).adapter = trendingTVAdapter
        })
        movieModel.queryTrendingTV(trendingTVLivedata)

        val upcomingTVLivedata = MutableLiveData<TrendingTVResponseWeekly>()
        upcomingTVLivedata.observe(viewLifecycleOwner, Observer {
            val trendingTVAdapter = context?.let { it1 -> TrendingAllAdapter(it1, it.results, movieModel) }
            v.findViewById<RecyclerView>(R.id.on_air).layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            v.findViewById<RecyclerView>(R.id.on_air).adapter = trendingTVAdapter
        })
        movieModel.queryUpcomingTV(upcomingTVLivedata, "popular")

        val topRatedTVLivedata = MutableLiveData<TrendingTVResponseWeekly>()
        topRatedTVLivedata.observe(viewLifecycleOwner, Observer {
            val trendingTVAdapter = context?.let { it1 -> TrendingAllAdapter(it1, it.results, movieModel) }
            v.findViewById<RecyclerView>(R.id.top_rated).layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            v.findViewById<RecyclerView>(R.id.top_rated).adapter = trendingTVAdapter
        })
        movieModel.queryUpcomingTV(topRatedTVLivedata, "airing_today")

        val nowPlayingTVLivedata = MutableLiveData<TrendingTVResponseWeekly>()
        nowPlayingTVLivedata.observe(viewLifecycleOwner, Observer {
            val trendingTVAdapter = context?.let { it1 -> TrendingAllAdapter(it1, it.results, movieModel) }
            v.findViewById<RecyclerView>(R.id.airing_today).layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            v.findViewById<RecyclerView>(R.id.airing_today).adapter = trendingTVAdapter
        })
        movieModel.queryUpcomingTV(nowPlayingTVLivedata, "on_the_air")

        val popularTVLivedata = MutableLiveData<TrendingTVResponseWeekly>()
        popularTVLivedata.observe(viewLifecycleOwner, Observer {
            val trendingTVAdapter = context?.let { it1 -> TrendingAllAdapter(it1, it.results, movieModel) }
            v.findViewById<RecyclerView>(R.id.popular).layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            v.findViewById<RecyclerView>(R.id.popular).adapter = trendingTVAdapter
        })
        movieModel.queryUpcomingTV(popularTVLivedata, "popular")




        return v
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }
}