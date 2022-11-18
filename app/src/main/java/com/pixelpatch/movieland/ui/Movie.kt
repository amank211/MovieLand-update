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
import com.pixelpatch.movieland.ui.adapter.TrendingAllAdapter
import com.pixelpatch.movieland.viewmodel.MovieViewModel

class Movie : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private val movieModel = MovieViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v: View = inflater.inflate(R.layout.movie_fragment, container, false)
        val trendingMovieLivedata = MutableLiveData<TrendingMovieResponseWeekly>()
        trendingMovieLivedata.observe(viewLifecycleOwner, Observer {
            val trendingMovieAdapter = context?.let { it1 -> TrendingAllAdapter(it1, it.results, movieModel) }
            v.findViewById<RecyclerView>(R.id.trending).layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            v.findViewById<RecyclerView>(R.id.trending).adapter = trendingMovieAdapter
        })
        movieModel.queryTrendingMovie(trendingMovieLivedata)

        val upcomingMovieLivedata = MutableLiveData<TrendingMovieResponseWeekly>()
        upcomingMovieLivedata.observe(viewLifecycleOwner, Observer {
            val trendingMovieAdapter = context?.let { it1 -> TrendingAllAdapter(it1, it.results, movieModel) }
            v.findViewById<RecyclerView>(R.id.upcoming).layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            v.findViewById<RecyclerView>(R.id.upcoming).adapter = trendingMovieAdapter
        })
        movieModel.queryUpcomingMovie(upcomingMovieLivedata, "popular")

        val topRatedMovieLivedata = MutableLiveData<TrendingMovieResponseWeekly>()
        topRatedMovieLivedata.observe(viewLifecycleOwner, Observer {
            val trendingMovieAdapter = context?.let { it1 -> TrendingAllAdapter(it1, it.results, movieModel) }
            v.findViewById<RecyclerView>(R.id.top_rated).layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            v.findViewById<RecyclerView>(R.id.top_rated).adapter = trendingMovieAdapter
        })
        movieModel.queryUpcomingMovie(topRatedMovieLivedata, "top_rated")

        val nowPlayingMovieLivedata = MutableLiveData<TrendingMovieResponseWeekly>()
        nowPlayingMovieLivedata.observe(viewLifecycleOwner, Observer {
            val trendingMovieAdapter = context?.let { it1 -> TrendingAllAdapter(it1, it.results, movieModel) }
            v.findViewById<RecyclerView>(R.id.now_playing).layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            v.findViewById<RecyclerView>(R.id.now_playing).adapter = trendingMovieAdapter
        })
        movieModel.queryUpcomingMovie(nowPlayingMovieLivedata, "now_playing")
        return v
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }
}