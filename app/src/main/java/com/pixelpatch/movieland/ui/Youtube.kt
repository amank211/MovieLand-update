package com.pixelpatch.movieland.ui

import android.content.Intent
import android.os.Bundle
import android.transition.Fade
import android.transition.Transition
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener
import com.google.android.youtube.player.YouTubePlayerView
import com.pixelpatch.movieland.Constants
import com.pixelpatch.movieland.MediaType
import com.pixelpatch.movieland.R
import com.pixelpatch.movieland.datamodels.movie.CastCrewResponse
import com.pixelpatch.movieland.datamodels.movie.MovieImageResponses
import com.pixelpatch.movieland.datamodels.movie.MovieResponse
import com.pixelpatch.movieland.datamodels.trending.TrendingMovieResponseWeekly
import com.pixelpatch.movieland.datamodels.trending.TrendingTVResponseWeekly
import com.pixelpatch.movieland.datamodels.tv.TVResponse
import com.pixelpatch.movieland.datamodels.video.VideoResponse
import com.pixelpatch.movieland.ui.adapter.ImageListAdapter
import com.pixelpatch.movieland.ui.adapter.TrendingAllAdapter
import com.pixelpatch.movieland.viewmodel.MovieViewModel
import com.squareup.picasso.Picasso


class Youtube : YouTubeBaseActivity(), Transition.TransitionListener, OnInitializedListener, OnTabSelectedListener {

    var key = ""
    val API_KEY = "AIzaSyDsyZPNvoYxxhzLTX_MmwKM776gZjej--A"
    lateinit var type: MediaType
    var id: Long = 0

    var movieViewModel = MovieViewModel()

    var observe = MutableLiveData<MovieResponse>()
    var observeTV = MutableLiveData<TVResponse>()

    lateinit var observer: Observer<MovieResponse>
    lateinit var observerTV: Observer<TVResponse>

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.getStringExtra("trailer_url")?.let { key = it }
        intent?.getSerializableExtra("type")?.let {
            type = it as MediaType
        }
        if (intent != null) {
            id = intent.getLongExtra("id", 0)
        }
    }

    override fun onResume() {
        super.onResume()

        // here we are initializing
        // fade animation.
        val fade = Fade()


        // here also we are excluding status bar,
        // action bar and navigation bar from animation.
        fade.excludeTarget(android.R.id.statusBarBackground, true)
        fade.excludeTarget(android.R.id.navigationBarBackground, true)



        // below methods are used for adding
        // enter and exit transition.
        window.enterTransition = fade
        window.exitTransition = fade

        findViewById<ImageView>(R.id.poster).transitionName = id.toString()

        if(type == MediaType.MOVIE && id >= 0){
            observer = Observer {
                var poster = findViewById<ImageView>(R.id.poster)
                findViewById<TextView>(R.id.title).text = it.title
                var summary = it.releaseDate + " . " + it.originalLanguage + " . " + it.runtime
                findViewById<TextView>(R.id.summary).text = summary
                findViewById<TextView>(R.id.overview).text = it.overview
                var genres = ""
                var count = 0
                run breaking@{
                    it.genres.forEach { genre ->
                        count++
                        if(count == 3){
                            genres += genre.name + ", "
                            return@breaking
                        } else {
                            genres += genre.name + ", "
                        }
                    }
                }

                if(genres.isNotEmpty())
                    findViewById<TextView>(R.id.genre).text = genres.substring(0,genres.length -2)

                var castObserver = MutableLiveData<CastCrewResponse>()
                castObserver.observeForever(Observer {
                    var castAdapter = TrendingAllAdapter(this, it.cast, movieViewModel)
                    findViewById<RecyclerView>(R.id.cast).layoutManager = GridLayoutManager(this, 3)
                    findViewById<RecyclerView>(R.id.cast).adapter = castAdapter
                })
                movieViewModel.queryMovieCredits(id, castObserver)

                var recommendObserver = MutableLiveData<TrendingMovieResponseWeekly>()
                recommendObserver.observeForever(Observer { it1 ->
                    var recommendAdapter = TrendingAllAdapter(this, it1.results, movieViewModel)
                    findViewById<RecyclerView>(R.id.recommended).layoutManager = GridLayoutManager(this, 3)
                    findViewById<RecyclerView>(R.id.recommended).adapter = recommendAdapter
                })
                movieViewModel.queryMovieRecommendation(id, recommendObserver)

                var similarObserver = MutableLiveData<TrendingMovieResponseWeekly>()
                similarObserver.observeForever(Observer { it1 ->
                    var similarAdapter = TrendingAllAdapter(this, it1.results, movieViewModel)
                    findViewById<RecyclerView>(R.id.similar).layoutManager = GridLayoutManager(this, 3)
                    findViewById<RecyclerView>(R.id.similar).adapter = similarAdapter
                })
                movieViewModel.queryMovieSimilar(id, similarObserver)

                var imagesObserver = MutableLiveData<MovieImageResponses>()
                imagesObserver.observeForever(Observer { it1 ->
                    var imageAdapter = ImageListAdapter(this, it1.backdrops, movieViewModel)
                    findViewById<RecyclerView>(R.id.photo_recycler).layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                    findViewById<RecyclerView>(R.id.photo_recycler).adapter = imageAdapter
                })
                movieViewModel.queryMovieImages(id, imagesObserver)

                Picasso.with(poster.context)
                    .load(Constants.IMAGE_PREFIX + it.posterPath)
                    .placeholder(R.drawable.placeholder)
                    .into(poster)
            }
            observe.observeForever(observer)
            movieViewModel.queryMovieInfo(id, observe)
        }
        if(type == MediaType.TV && id >= 0){
            observerTV = Observer {
                var poster = findViewById<ImageView>(R.id.poster)
                findViewById<TextView>(R.id.title).text = it.originalName
                var summary = it.firstAirDate + " . " + it.originalLanguage + " . " + it.seasons.size + " seasons"

                var genres = ""
                var count = 0
                run breaking@{
                    it.genres.forEach { genre ->
                        count++
                        if(count == 3){
                            genres += genre.name + ", "
                            return@breaking
                        } else {
                            genres += genre.name + ", "
                        }
                    }
                }

                if(genres.isNotEmpty())
                    findViewById<TextView>(R.id.genre).text = genres.substring(0,genres.length -2)
                findViewById<TextView>(R.id.summary).text = summary
                findViewById<TextView>(R.id.overview).text = it.overview
                var castObserver = MutableLiveData<CastCrewResponse>()
                castObserver.observeForever(Observer {
                    var castAdapter = TrendingAllAdapter(this, it.cast, movieViewModel)
                    findViewById<RecyclerView>(R.id.cast).layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                    findViewById<RecyclerView>(R.id.cast).adapter = castAdapter
                })
                movieViewModel.queryTVCredits(id, castObserver)

                var recommendObserver = MutableLiveData<TrendingTVResponseWeekly>()
                recommendObserver.observeForever(Observer { it1 ->
                    var recommendAdapter = TrendingAllAdapter(this, it1.results, movieViewModel)
                    findViewById<RecyclerView>(R.id.recommended).layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                    findViewById<RecyclerView>(R.id.recommended).adapter = recommendAdapter
                })
                movieViewModel.queryTVRecommendation(id, recommendObserver)

                var similarObserver = MutableLiveData<TrendingTVResponseWeekly>()
                similarObserver.observeForever(Observer { it1 ->
                    var similarAdapter = TrendingAllAdapter(this, it1.results, movieViewModel)
                    findViewById<RecyclerView>(R.id.similar).layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                    findViewById<RecyclerView>(R.id.similar).adapter = similarAdapter
                })
                movieViewModel.queryTVSimilar(id, similarObserver)

                Picasso.with(poster.context).load(Constants.IMAGE_PREFIX + it.posterPath).placeholder(R.drawable.placeholder).into(poster)
            }
            observeTV.observeForever(observerTV)
            movieViewModel.queryTVInfo(id, observeTV)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube)

        intent.getStringExtra("trailer_url")?.let { key = it }
        intent.getSerializableExtra("type")?.let {
            type = it as MediaType
        }
        id = intent.getLongExtra("id", 0)
        findViewById<ImageView>(R.id.poster).transitionName = id.toString()
        findViewById<TabLayout>(R.id.tabs).addOnTabSelectedListener(this)
        window.sharedElementEnterTransition.addListener(this)
        var adView = findViewById<View>(com.pixelpatch.movieland.R.id.ad_view) as AdView
        var adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onTransitionStart(transition: Transition?) {
    }

    override fun onTransitionEnd(transition: Transition?) {

        if(type == MediaType.MOVIE && id >= 0) {

            var observeVideo = MutableLiveData<VideoResponse>()
            observeVideo.observeForever(Observer { results ->

                run breaking@{
                    results.results.forEach {
                        if (it.type == "Trailer") {
                            this.key = it.key
                            findViewById<YouTubePlayerView>(R.id.youtube).initialize(API_KEY, this)
                            return@breaking
                        }
                    }
                }

            })
            movieViewModel.queryVideo(id, observeVideo)
        }
        if(type == MediaType.TV && id >= 0) {
            var observeVideo = MutableLiveData<VideoResponse>()
            observeVideo.observeForever(Observer { results ->
                run breaking@{
                    results.results.forEach {
                        if (it.type == "Trailer") {
                            Log.d("HELLLO", "key: " + it.key)
                            this.key = it.key
                            findViewById<YouTubePlayerView>(R.id.youtube).initialize(API_KEY, this)
                            return@breaking
                        }
                    }
                }
            })
            movieViewModel.queryVideoTV(id, observeVideo)
        }
    }

    override fun onTransitionCancel(transition: Transition?) {
    }

    override fun onTransitionPause(transition: Transition?) {
    }

    override fun onTransitionResume(transition: Transition?) {
    }

    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        p1: YouTubePlayer?,
        p2: Boolean
    ) {
        p1?.loadVideo(key)
        p1?.play()
    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        when(tab?.text){
            "INFO" -> {
                val scrollView: NestedScrollView = findViewById(R.id.scroller)
                val apBar: AppBarLayout = findViewById(R.id.appbar)
                apBar.setExpanded(false)
                val view: View = findViewById(R.id.info_layout)

                scrollView.smoothScrollTo(view.x.toInt(), view.y.toInt())
            }
            "CAST" -> {
                val scrollView: NestedScrollView = findViewById(R.id.scroller)
                val apBar: AppBarLayout = findViewById(R.id.appbar)
                apBar.setExpanded(false)
                val view: View = findViewById(R.id.cast_layout)

                scrollView.smoothScrollTo(view.x.toInt(), view.y.toInt())
            }
            "SIMILAR" -> {
                val scrollView: NestedScrollView = findViewById(R.id.scroller)
                val apBar: AppBarLayout = findViewById(R.id.appbar)
                apBar.setExpanded(false)
                val view: View = findViewById(R.id.similar_layout)

                scrollView.smoothScrollTo(view.x.toInt(), view.y.toInt())
            }
        }

    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }

}