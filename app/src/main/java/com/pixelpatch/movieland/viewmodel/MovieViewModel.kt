package com.pixelpatch.movieland.viewmodel

import ImagesOfPersonResponse
import androidx.lifecycle.MutableLiveData
import com.pixelpatch.movieland.MediaType
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
import com.pixelpatch.movieland.repository.MovieRepository

class MovieViewModel {

    private var movieRepository = MovieRepository()

    fun queryTrendingAll(response: MutableLiveData<TrendingAllResponseWeekly>){
        movieRepository.queryTrendingAll( response, true, MediaType.ALL)
    }

    fun queryTrendingMovie(response: MutableLiveData<TrendingMovieResponseWeekly>){
        movieRepository.queryTrendingMovie(response, true, MediaType.MOVIE)
    }

    fun queryDiscoverMovie(response: MutableLiveData<TrendingMovieResponseWeekly>){
        movieRepository.queryDiscoverMovie(response, true, MediaType.MOVIE)
    }

    fun queryDiscoverTV(response: MutableLiveData<TrendingTVResponseWeekly>){
        movieRepository.queryDiscoverTV(response, true, MediaType.MOVIE)
    }

    fun queryUpcomingMovie(response: MutableLiveData<TrendingMovieResponseWeekly>, name: String){
        movieRepository.queryUpcomingMovie(response, true, MediaType.MOVIE, name)
    }

    fun queryUpcomingTV(response: MutableLiveData<TrendingTVResponseWeekly>, name: String){
        movieRepository.queryUpcomingTV(response, true, MediaType.MOVIE, name)
    }

    fun queryTrendingTV(response: MutableLiveData<TrendingTVResponseWeekly>){
        movieRepository.queryTrendingTV(response, true, MediaType.MOVIE)
    }

    fun queryTrendingPerson(response: MutableLiveData<TrendingPersonResponseWeekly>){
        movieRepository.queryTrendingPerson(response, true, MediaType.MOVIE)
    }

    fun queryVideo(id: Long, observer: MutableLiveData<VideoResponse>){
        movieRepository.queryVideo(id, observer, "movie")
    }

    fun queryVideoTV(id: Long, observer: MutableLiveData<VideoResponse>){
        movieRepository.queryVideo(id, observer, "tv")
    }

    fun queryMovieInfo(id: Long, observer: MutableLiveData<MovieResponse>){
        movieRepository.queryMovieInfo(id, observer)
    }

    fun queryTVInfo(id: Long, observer: MutableLiveData<TVResponse>){
        movieRepository.queryTVInfo(id, observer)
    }

    fun queryMovieCredits(id: Long, observer: MutableLiveData<CastCrewResponse>){
        movieRepository.queryMovieCredits(id, observer)
    }

    fun queryMovieImages(id: Long, observer: MutableLiveData<MovieImageResponses>){
        movieRepository.queryMovieImages(id, observer)
    }

    fun queryTVCredits(id: Long, observer: MutableLiveData<CastCrewResponse>){
        movieRepository.queryTVCredits(id, observer)
    }

    fun queryMovieRecommendation(id: Long, observer: MutableLiveData<TrendingMovieResponseWeekly>){
        movieRepository.queryMovieRecommendation(id, observer)
    }

    fun queryTVRecommendation(id: Long, observer: MutableLiveData<TrendingTVResponseWeekly>){
        movieRepository.queryTVRecommendation(id, observer)
    }

    fun queryMovieSimilar(id: Long, observer: MutableLiveData<TrendingMovieResponseWeekly>){
        movieRepository.queryMovieSimilar(id, observer)
    }

    fun queryTVSimilar(id: Long, observer: MutableLiveData<TrendingTVResponseWeekly>){
        movieRepository.queryTVSimilar(id, observer)
    }

    fun queryPopularPersons(id: Long, observer: MutableLiveData<PopularPersonResponse>){
        movieRepository.queryPopularPersons(id, observer)
    }

    fun queryPersonMovies(id: Long, observer: MutableLiveData<PersonMoviesResponse>){
        movieRepository.queryPersonMovies(id, observer)
    }

    fun queryPersonTvs(id: Long, observer: MutableLiveData<PersonTvResponse>){
        movieRepository.queryPersonTVs(id, observer)
    }

    fun queryPersonImages(id: Long, observer: MutableLiveData<ImagesOfPersonResponse>){
        movieRepository.queryImagesOfPerson(id, observer)
    }

    fun queryPersonInfo(id: Long, observer: MutableLiveData<PersonInfoResponse>){
        movieRepository.queryPersonInfo(id, observer)
    }

    fun searchForMovies(query: String, observer: MutableLiveData<MovieSearchResponse>){
        movieRepository.searchMovie(query, observer)
    }

    fun searchForTVs(query: String, observer: MutableLiveData<TVSearchResponse>){
        movieRepository.searchTV(query, observer)
    }

    fun searchForPerson(query: String, observer: MutableLiveData<PersonSearchResponse>){
        movieRepository.searchPerson(query, observer)
    }
}