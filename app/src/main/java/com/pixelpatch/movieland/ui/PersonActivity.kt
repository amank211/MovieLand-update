package com.pixelpatch.movieland.ui

import ImagesOfPersonResponse
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.transition.Transition
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import com.pixelpatch.movieland.Constants
import com.pixelpatch.movieland.MediaType
import com.pixelpatch.movieland.R
import com.pixelpatch.movieland.datamodels.person.PersonInfoResponse
import com.pixelpatch.movieland.datamodels.person.PersonMoviesResponse
import com.pixelpatch.movieland.datamodels.person.PersonTvResponse
import com.pixelpatch.movieland.ui.adapter.ImageViewPager
import com.pixelpatch.movieland.ui.adapter.TrendingAllAdapter
import com.pixelpatch.movieland.viewmodel.MovieViewModel
import com.squareup.picasso.Picasso

class PersonActivity : AppCompatActivity(), Transition.TransitionListener, TabLayout.OnTabSelectedListener {

    var id: Long = 0
    lateinit var type: MediaType
    private var isAnimationStarted = false

    var movieViewModel = MovieViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        intent.getSerializableExtra("type")?.let {
            type = it as MediaType
        }
        id = intent.getLongExtra("id", 0)
        findViewById<ImageView>(R.id.poster).transitionName = id.toString()

//        var tab1 = TabLayout.Tab()
//        tab1.text = "Info"
//        var tab2 = TabLayout.Tab()
//        tab2.text = "Cast"
//        var tab3 = TabLayout.Tab()
//        tab3.text = "????"
//
//        findViewById<TabLayout>(R.id.tabs).addTab(tab1)
//        findViewById<TabLayout>(R.id.tabs).addTab(tab2)
//        findViewById<TabLayout>(R.id.tabs).addTab(tab1)
        findViewById<TabLayout>(R.id.tabs).addOnTabSelectedListener(this)
        window.sharedElementEnterTransition.addListener(this)

        var adView = findViewById<View>(com.pixelpatch.movieland.R.id.ad_view) as AdView
        var adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }


    private val runnable = Runnable {
            Log.d("AMAN", "runnable")
            queryAPIs()
    }

    lateinit var handler: Handler

    override fun onResume() {
        handler = Handler(Looper.myLooper()!!)
        handler.postDelayed( runnable, 1300)
        super.onResume()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onTransitionStart(transition: Transition?) {
        isAnimationStarted = true
        Log.d("AMAN", "onTransitionStart")
    }

    fun queryAPIs(){
        Log.d("AMAN", "queryAPIs")
        var imagesObserver = MutableLiveData<ImagesOfPersonResponse>()
        imagesObserver.observeForever(Observer {
            var imageAdapter = ImageViewPager(this, it.results)
            var viewPager = findViewById<ViewPager>(R.id.person_images)
            viewPager.adapter = imageAdapter
        })
        movieViewModel.queryPersonImages(id, imagesObserver)

        var infoObserver = MutableLiveData<PersonInfoResponse>()
        infoObserver.observeForever(Observer {
            findViewById<TextView>(R.id.title).text = it.name
            findViewById<TextView>(R.id.overview).text = it.biography
            var poster: ImageView = findViewById(R.id.poster)
            Picasso.with(poster.context)
                .load(Constants.IMAGE_PREFIX + it.profilePath)
                .placeholder(R.drawable.placeholder)
                .into(poster)
        })
        movieViewModel.queryPersonInfo(id, infoObserver)

        var movieObserver = MutableLiveData<PersonMoviesResponse>()
        movieObserver.observeForever(Observer {
            var recommendAdapter = TrendingAllAdapter(this, it.cast, movieViewModel)
            findViewById<RecyclerView>(R.id.movies).layoutManager = GridLayoutManager(this, 3)
            findViewById<RecyclerView>(R.id.movies).adapter = recommendAdapter
        })
        movieViewModel.queryPersonMovies(id, movieObserver)

        var tvObserver = MutableLiveData<PersonTvResponse>()
        tvObserver.observeForever(Observer {
            var recommendAdapter = TrendingAllAdapter(this, it.cast, movieViewModel)
            findViewById<RecyclerView>(R.id.tv_shows).layoutManager = GridLayoutManager(this, 3)
            findViewById<RecyclerView>(R.id.tv_shows).adapter = recommendAdapter
        })
        movieViewModel.queryPersonTvs(id, tvObserver)
    }

    override fun onTransitionEnd(transition: Transition?) {
        handler.removeCallbacks(runnable)
            queryAPIs()
    }

    override fun onTransitionCancel(transition: Transition?) {
        
    }

    override fun onTransitionPause(transition: Transition?) {
        
    }

    override fun onTransitionResume(transition: Transition?) {
        
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
            "MOVIES" -> {
                val scrollView: NestedScrollView = findViewById(R.id.scroller)
                val apBar: AppBarLayout = findViewById(R.id.appbar)
                apBar.setExpanded(false)
                val view: View = findViewById(R.id.movie_layout)
                scrollView.smoothScrollTo(view.x.toInt(), view.y.toInt())
            }
            "TV SHOWS" -> {
                val scrollView: NestedScrollView = findViewById(R.id.scroller)
                val apBar: AppBarLayout = findViewById(R.id.appbar)
                apBar.setExpanded(false)
                val view: View = findViewById(R.id.tv_layout)
                scrollView.smoothScrollTo(view.x.toInt(), view.y.toInt())
            }
        }
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {

    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
        when(tab?.text){
            "INFO" -> {
                val scrollView: NestedScrollView = findViewById(R.id.scroller)
                val apBar: AppBarLayout = findViewById(R.id.appbar)
                apBar.setExpanded(false)
                val view: View = findViewById(R.id.info_layout)

                scrollView.smoothScrollTo(view.x.toInt(), view.y.toInt())
            }
            "MOVIES" -> {
                val scrollView: NestedScrollView = findViewById(R.id.scroller)
                val apBar: AppBarLayout = findViewById(R.id.appbar)
                apBar.setExpanded(false)
                val view: View = findViewById(R.id.movie_layout)
                scrollView.smoothScrollTo(view.x.toInt(), view.y.toInt())
            }
            "TV SHOWS" -> {
                val scrollView: NestedScrollView = findViewById(R.id.scroller)
                val apBar: AppBarLayout = findViewById(R.id.appbar)
                apBar.setExpanded(false)
                val view: View = findViewById(R.id.tv_layout)
                scrollView.smoothScrollTo(view.x.toInt(), view.y.toInt())
            }
        }
    }
}