package com.pixelpatch.movieland.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pixelpatch.movieland.R
import com.pixelpatch.movieland.datamodels.trending.TrendingPersonResponseWeekly
import com.pixelpatch.movieland.ui.adapter.TrendingAllAdapter
import com.pixelpatch.movieland.viewmodel.MovieViewModel

class Celebrities : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    val movieViewModel = MovieViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.celebrity_fragment, container, false)
        val trendingPersonLivedata = MutableLiveData<TrendingPersonResponseWeekly>()
        trendingPersonLivedata.observeForever( Observer {
            var trendingPersonAdapter =
                context?.let { it1 -> TrendingAllAdapter(it1, it.results, movieViewModel) }
            v.findViewById<RecyclerView>(R.id.trending_person).layoutManager = GridLayoutManager(context, 3)
            v.findViewById<RecyclerView>(R.id.trending_person).adapter = trendingPersonAdapter
        })
        movieViewModel.queryTrendingPerson(trendingPersonLivedata)
        return v
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }
}