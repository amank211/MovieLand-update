package com.pixelpatch.movieland.repository

import ImagesOfPersonResponse
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.pixelpatch.movieland.MediaType
import com.pixelpatch.movieland.client.IAPIClient
import com.pixelpatch.movieland.datamodels.movie.CastCrewResponse
import com.pixelpatch.movieland.datamodels.movie.MovieImageResponses
import com.pixelpatch.movieland.datamodels.movie.MovieResponse
import com.pixelpatch.movieland.datamodels.person.PersonInfoResponse
import com.pixelpatch.movieland.datamodels.person.PersonMoviesResponse
import com.pixelpatch.movieland.datamodels.person.PersonTvResponse
import com.pixelpatch.movieland.datamodels.person.PopularPersonResponse
import com.pixelpatch.movieland.datamodels.search.MovieSearchResponse
import com.pixelpatch.movieland.datamodels.search.PersonSearchResponse
import com.pixelpatch.movieland.datamodels.search.TVSearchResponse
import com.pixelpatch.movieland.datamodels.trending.TrendingAllResponseWeekly
import com.pixelpatch.movieland.datamodels.trending.TrendingMovieResponseWeekly
import com.pixelpatch.movieland.datamodels.trending.TrendingPersonResponseWeekly
import com.pixelpatch.movieland.datamodels.trending.TrendingTVResponseWeekly
import com.pixelpatch.movieland.datamodels.tv.TVResponse
import com.pixelpatch.movieland.datamodels.video.VideoResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRepository {
    private val mClient: IAPIClient

    companion object {
        private const val API_KEY = "223444c9a68bd2763fbf89598bb95134"
        private const val BASE_URL = "https://api.themoviedb.org/"
    }

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        mClient = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IAPIClient::class.java)
    }

    fun queryTrendingAll(observer: MutableLiveData<TrendingAllResponseWeekly>, isWeekly : Boolean, mediaType: MediaType) {
        var call: Call<TrendingAllResponseWeekly> = mClient.getTrendingAll(API_KEY)
        call.enqueue(object : Callback<TrendingAllResponseWeekly?> {
            override fun onResponse(
                call: Call<TrendingAllResponseWeekly?>,
                response: Response<TrendingAllResponseWeekly?>
            ) {
                val resource: TrendingAllResponseWeekly = response.body()!!

                if(observer.hasObservers())
                    observer.value = resource
            }

            override fun onFailure(call: Call<TrendingAllResponseWeekly?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryTrendingMovie(observer: MutableLiveData<TrendingMovieResponseWeekly>, isWeekly : Boolean, mediaType: MediaType) {
        var call: Call<TrendingMovieResponseWeekly> = mClient.getTrendingMovie(API_KEY)
        call.enqueue(object : Callback<TrendingMovieResponseWeekly?> {
            override fun onResponse(
                call: Call<TrendingMovieResponseWeekly?>,
                response: Response<TrendingMovieResponseWeekly?>
            ) {
                val resource: TrendingMovieResponseWeekly = response.body()!!
                Log.d("AMAN", observer.hasObservers().toString())


                if(observer.hasObservers())
                    observer.value = resource
            }

            override fun onFailure(call: Call<TrendingMovieResponseWeekly?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryDiscoverMovie(observer: MutableLiveData<TrendingMovieResponseWeekly>, isWeekly : Boolean, mediaType: MediaType) {
        var call: Call<TrendingMovieResponseWeekly> = mClient.getDiscoverMovie(API_KEY)
        call.enqueue(object : Callback<TrendingMovieResponseWeekly?> {
            override fun onResponse(
                call: Call<TrendingMovieResponseWeekly?>,
                response: Response<TrendingMovieResponseWeekly?>
            ) {
                val resource: TrendingMovieResponseWeekly = response.body()!!
                Log.d("AMAN", observer.hasObservers().toString())


                if(observer.hasObservers())
                    observer.value = resource
            }

            override fun onFailure(call: Call<TrendingMovieResponseWeekly?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryDiscoverTV(observer: MutableLiveData<TrendingTVResponseWeekly>, isWeekly : Boolean, mediaType: MediaType) {
        var call: Call<TrendingTVResponseWeekly> = mClient.getDiscoverTV(API_KEY)
        call.enqueue(object : Callback<TrendingTVResponseWeekly?> {
            override fun onResponse(
                call: Call<TrendingTVResponseWeekly?>,
                response: Response<TrendingTVResponseWeekly?>
            ) {
                val resource: TrendingTVResponseWeekly = response.body()!!
                Log.d("AMAN", observer.hasObservers().toString())


                if(observer.hasObservers())
                    observer.value = resource
            }

            override fun onFailure(call: Call<TrendingTVResponseWeekly?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryUpcomingMovie(observer: MutableLiveData<TrendingMovieResponseWeekly>, isWeekly : Boolean, mediaType: MediaType, name: String) {
        var call: Call<TrendingMovieResponseWeekly> = mClient.getUpcomingMovie(name, API_KEY)
        call.enqueue(object : Callback<TrendingMovieResponseWeekly?> {
            override fun onResponse(
                call: Call<TrendingMovieResponseWeekly?>,
                response: Response<TrendingMovieResponseWeekly?>
            ) {
                val resource: TrendingMovieResponseWeekly = response.body()!!
                Log.d("AMAN", observer.hasObservers().toString())


                if(observer.hasObservers())
                    observer.value = resource
            }

            override fun onFailure(call: Call<TrendingMovieResponseWeekly?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryUpcomingTV(observer: MutableLiveData<TrendingTVResponseWeekly>, isWeekly : Boolean, mediaType: MediaType, name: String) {
        var call: Call<TrendingTVResponseWeekly> = mClient.getUpcomingTV(name, API_KEY)
        call.enqueue(object : Callback<TrendingTVResponseWeekly?> {
            override fun onResponse(
                call: Call<TrendingTVResponseWeekly?>,
                response: Response<TrendingTVResponseWeekly?>
            ) {
                val resource: TrendingTVResponseWeekly = response.body()!!
                Log.d("AMAN", observer.hasObservers().toString())


                if(observer.hasObservers())
                    observer.value = resource
            }

            override fun onFailure(call: Call<TrendingTVResponseWeekly?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryTrendingTV(observer: MutableLiveData<TrendingTVResponseWeekly>, isWeekly : Boolean, mediaType: MediaType) {
        var call: Call<TrendingTVResponseWeekly> = mClient.getTrendingTv(API_KEY)
        call.enqueue(object : Callback<TrendingTVResponseWeekly?> {
            override fun onResponse(
                call: Call<TrendingTVResponseWeekly?>,
                response: Response<TrendingTVResponseWeekly?>
            ) {
                val resource: TrendingTVResponseWeekly = response.body()!!
                Log.d("AMAN", observer.hasObservers().toString())


                if(observer.hasObservers())
                    observer.value = resource
            }

            override fun onFailure(call: Call<TrendingTVResponseWeekly?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryTrendingPerson(observer: MutableLiveData<TrendingPersonResponseWeekly>, isWeekly : Boolean, mediaType: MediaType) {
        var call: Call<TrendingPersonResponseWeekly> = mClient.getTrendingPerson(API_KEY)
        call.enqueue(object : Callback<TrendingPersonResponseWeekly?> {
            override fun onResponse(
                call: Call<TrendingPersonResponseWeekly?>,
                response: Response<TrendingPersonResponseWeekly?>
            ) {
                val resource: TrendingPersonResponseWeekly = response.body()!!
                Log.d("AMAN", observer.hasObservers().toString())


                if(observer.hasObservers())
                    observer.value = resource
            }

            override fun onFailure(call: Call<TrendingPersonResponseWeekly?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryVideo(id : Long, observer: MutableLiveData<VideoResponse>, type: String) {
        var call: Call<VideoResponse> = mClient.getVideo(type, id, API_KEY)
        call.enqueue(object : Callback<VideoResponse?> {
            override fun onResponse(
                call: Call<VideoResponse?>,
                response: Response<VideoResponse?>
            ) {
                val resource: VideoResponse = response.body()!!
                if(observer.hasObservers())
                    observer.value = resource
            }
            override fun onFailure(call: Call<VideoResponse?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryTVVideo(id : Long, observer: MutableLiveData<VideoResponse>) {
        var call: Call<VideoResponse> = mClient.getVideo("tv", id, API_KEY)
        call.enqueue(object : Callback<VideoResponse?> {
            override fun onResponse(
                call: Call<VideoResponse?>,
                response: Response<VideoResponse?>
            ) {
                val resource: VideoResponse = response.body()!!
                if(observer.hasObservers())
                    observer.value = resource
            }
            override fun onFailure(call: Call<VideoResponse?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryMovieInfo(id : Long,  observer: MutableLiveData<MovieResponse>) {
        var call: Call<MovieResponse> = mClient.getMovieDetails( id, API_KEY)
        call.enqueue(object : Callback<MovieResponse?> {
            override fun onResponse(
                call: Call<MovieResponse?>,
                response: Response<MovieResponse?>
            ) {
                val resource: MovieResponse = response.body()!!
                if(observer.hasObservers())
                    observer.value = resource
            }
            override fun onFailure(call: Call<MovieResponse?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryTVInfo(id : Long,  observer: MutableLiveData<TVResponse>) {
        var call: Call<TVResponse> = mClient.getTVDetails( id, API_KEY)
        call.enqueue(object : Callback<TVResponse?> {
            override fun onResponse(
                call: Call<TVResponse?>,
                response: Response<TVResponse?>
            ) {
                val resource: TVResponse = response.body()!!
                if(observer.hasObservers())
                    observer.value = resource
            }
            override fun onFailure(call: Call<TVResponse?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryMovieCredits(id : Long,  observer: MutableLiveData<CastCrewResponse>) {
        var call: Call<CastCrewResponse> = mClient.getMovieCredits("movie", id, API_KEY)
        call.enqueue(object : Callback<CastCrewResponse?> {
            override fun onResponse(
                call: Call<CastCrewResponse?>,
                response: Response<CastCrewResponse?>
            ) {
                val resource: CastCrewResponse = response.body()!!
                if(observer.hasObservers())
                    observer.value = resource
            }
            override fun onFailure(call: Call<CastCrewResponse?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryMovieImages(id : Long,  observer: MutableLiveData<MovieImageResponses>) {
        var call: Call<MovieImageResponses> = mClient.getMovieImages( id, API_KEY, "en")
        call.enqueue(object : Callback<MovieImageResponses?> {
            override fun onResponse(
                call: Call<MovieImageResponses?>,
                response: Response<MovieImageResponses?>
            ) {
                val resource: MovieImageResponses = response.body()!!
                if(observer.hasObservers())
                    observer.value = resource
            }
            override fun onFailure(call: Call<MovieImageResponses?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryTVCredits(id : Long,  observer: MutableLiveData<CastCrewResponse>) {
        var call: Call<CastCrewResponse> = mClient.getMovieCredits("tv", id, API_KEY)
        call.enqueue(object : Callback<CastCrewResponse?> {
            override fun onResponse(
                call: Call<CastCrewResponse?>,
                response: Response<CastCrewResponse?>
            ) {
                val resource: CastCrewResponse = response.body()!!
                if(observer.hasObservers())
                    observer.value = resource
            }
            override fun onFailure(call: Call<CastCrewResponse?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryMovieRecommendation(id : Long,  observer: MutableLiveData<TrendingMovieResponseWeekly>) {
        var call: Call<TrendingMovieResponseWeekly> = mClient.getRecommendedMovies( id, API_KEY)
        call.enqueue(object : Callback<TrendingMovieResponseWeekly?> {
            override fun onResponse(
                call: Call<TrendingMovieResponseWeekly?>,
                response: Response<TrendingMovieResponseWeekly?>
            ) {
                val resource: TrendingMovieResponseWeekly = response.body()!!
                if(observer.hasObservers())
                    observer.value = resource
            }
            override fun onFailure(call: Call<TrendingMovieResponseWeekly?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryTVRecommendation(id : Long,  observer: MutableLiveData<TrendingTVResponseWeekly>) {
        var call: Call<TrendingTVResponseWeekly> = mClient.getRecommendedTVs( id, API_KEY)
        call.enqueue(object : Callback<TrendingTVResponseWeekly?> {
            override fun onResponse(
                call: Call<TrendingTVResponseWeekly?>,
                response: Response<TrendingTVResponseWeekly?>
            ) {
                val resource: TrendingTVResponseWeekly = response.body()!!
                if(observer.hasObservers())
                    observer.value = resource
            }
            override fun onFailure(call: Call<TrendingTVResponseWeekly?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryMovieSimilar(id : Long,  observer: MutableLiveData<TrendingMovieResponseWeekly>) {
        var call: Call<TrendingMovieResponseWeekly> = mClient.getSimilarMovies( id, API_KEY)
        call.enqueue(object : Callback<TrendingMovieResponseWeekly?> {
            override fun onResponse(
                call: Call<TrendingMovieResponseWeekly?>,
                response: Response<TrendingMovieResponseWeekly?>
            ) {
                val resource: TrendingMovieResponseWeekly = response.body()!!
                if(observer.hasObservers())
                    observer.value = resource
            }
            override fun onFailure(call: Call<TrendingMovieResponseWeekly?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryTVSimilar(id : Long,  observer: MutableLiveData<TrendingTVResponseWeekly>) {
        var call: Call<TrendingTVResponseWeekly> = mClient.getSimilarTVs( id, API_KEY)
        call.enqueue(object : Callback<TrendingTVResponseWeekly?> {
            override fun onResponse(
                call: Call<TrendingTVResponseWeekly?>,
                response: Response<TrendingTVResponseWeekly?>
            ) {
                val resource: TrendingTVResponseWeekly = response.body()!!
                if(observer.hasObservers())
                    observer.value = resource
            }
            override fun onFailure(call: Call<TrendingTVResponseWeekly?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryPopularPersons(id : Long,  observer: MutableLiveData<PopularPersonResponse>) {
        var call: Call<PopularPersonResponse> = mClient.getPopularPersons(API_KEY)
        call.enqueue(object : Callback<PopularPersonResponse?> {
            override fun onResponse(
                call: Call<PopularPersonResponse?>,
                response: Response<PopularPersonResponse?>
            ) {
                val resource: PopularPersonResponse = response.body()!!
                if(observer.hasObservers())
                    observer.value = resource
            }
            override fun onFailure(call: Call<PopularPersonResponse?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryPersonMovies(id : Long,  observer: MutableLiveData<PersonMoviesResponse>) {
        var call: Call<PersonMoviesResponse> = mClient.getMovieOfPerson(id, API_KEY)
        call.enqueue(object : Callback<PersonMoviesResponse?> {
            override fun onResponse(
                call: Call<PersonMoviesResponse?>,
                response: Response<PersonMoviesResponse?>
            ) {
                val resource: PersonMoviesResponse = response.body()!!
                if(observer.hasObservers())
                    observer.value = resource
            }
            override fun onFailure(call: Call<PersonMoviesResponse?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryPersonTVs(id : Long,  observer: MutableLiveData<PersonTvResponse>) {
        var call: Call<PersonTvResponse> = mClient.getTvOfPerson(id, API_KEY)
        call.enqueue(object : Callback<PersonTvResponse?> {
            override fun onResponse(
                call: Call<PersonTvResponse?>,
                response: Response<PersonTvResponse?>
            ) {
                val resource: PersonTvResponse = response.body()!!
                if(observer.hasObservers())
                    observer.value = resource
            }
            override fun onFailure(call: Call<PersonTvResponse?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryImagesOfPerson(id : Long,  observer: MutableLiveData<ImagesOfPersonResponse>) {
        var call: Call<ImagesOfPersonResponse> = mClient.getImagesOfPerson(id, API_KEY)
        call.enqueue(object : Callback<ImagesOfPersonResponse?> {
            override fun onResponse(
                call: Call<ImagesOfPersonResponse?>,
                response: Response<ImagesOfPersonResponse?>
            ) {
                val resource: ImagesOfPersonResponse = response.body()!!
                if(observer.hasObservers())
                    observer.value = resource
            }
            override fun onFailure(call: Call<ImagesOfPersonResponse?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun queryPersonInfo(id : Long,  observer: MutableLiveData<PersonInfoResponse>) {
        var call: Call<PersonInfoResponse> = mClient.getInfoOfPerson(id, API_KEY)
        call.enqueue(object : Callback<PersonInfoResponse?> {
            override fun onResponse(
                call: Call<PersonInfoResponse?>,
                response: Response<PersonInfoResponse?>
            ) {
                val resource: PersonInfoResponse = response.body()!!
                if(observer.hasObservers())
                    observer.value = resource
            }
            override fun onFailure(call: Call<PersonInfoResponse?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun searchMovie(query : String, observer: MutableLiveData<MovieSearchResponse>) {
        var call: Call<MovieSearchResponse> = mClient.searchForMovie(query, API_KEY)
        call.enqueue(object : Callback<MovieSearchResponse?> {
            override fun onResponse(
                call: Call<MovieSearchResponse?>,
                response: Response<MovieSearchResponse?>
            ) {
                val resource: MovieSearchResponse = response.body()!!
                if(observer.hasObservers())
                    observer.value = resource
            }
            override fun onFailure(call: Call<MovieSearchResponse?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun searchTV(query : String, observer: MutableLiveData<TVSearchResponse>) {
        var call: Call<TVSearchResponse> = mClient.searchForTV(query, API_KEY)
        call.enqueue(object : Callback<TVSearchResponse?> {
            override fun onResponse(
                call: Call<TVSearchResponse?>,
                response: Response<TVSearchResponse?>
            ) {
                val resource: TVSearchResponse = response.body()!!
                if(observer.hasObservers())
                    observer.value = resource
            }
            override fun onFailure(call: Call<TVSearchResponse?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }

    fun searchPerson(query : String, observer: MutableLiveData<PersonSearchResponse>) {
        var call: Call<PersonSearchResponse> = mClient.searchForPerson(query, API_KEY)
        call.enqueue(object : Callback<PersonSearchResponse?> {
            override fun onResponse(
                call: Call<PersonSearchResponse?>,
                response: Response<PersonSearchResponse?>
            ) {
                val resource: PersonSearchResponse = response.body()!!
                if(observer.hasObservers())
                    observer.value = resource
            }
            override fun onFailure(call: Call<PersonSearchResponse?>, t: Throwable) {
                if(observer.hasObservers())
                    observer.value = null
                call.cancel()
            }
        })
    }
}