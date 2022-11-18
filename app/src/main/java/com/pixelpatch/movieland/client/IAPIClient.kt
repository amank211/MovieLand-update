package com.pixelpatch.movieland.client

import ImagesOfPersonResponse
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
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IAPIClient {

    @GET("/3/trending/all/week")
    fun getTrendingAll(@Query("api_key") apiKey: String)
    : Call<TrendingAllResponseWeekly>

    @GET("/3/trending/tv/week")
    fun getTrendingTv(@Query("api_key") apiKey: String)
            : Call<TrendingTVResponseWeekly>

    @GET("/3/trending/movie/week")
    fun getTrendingMovie(@Query("api_key") apiKey: String)
            : Call<TrendingMovieResponseWeekly>

    @GET("/3/discover/movie")
    fun getDiscoverMovie(@Query("api_key") apiKey: String)
            : Call<TrendingMovieResponseWeekly>

    @GET("/3/discover/tv")
    fun getDiscoverTV(@Query("api_key") apiKey: String)
            : Call<TrendingTVResponseWeekly>

    @GET("/3/movie/{name}")
    fun getUpcomingMovie( @Path("name") id: String, @Query("api_key") apiKey: String)
            : Call<TrendingMovieResponseWeekly>

    @GET("/3/tv/{name}")
    fun getUpcomingTV( @Path("name") id: String, @Query("api_key") apiKey: String)
            : Call<TrendingTVResponseWeekly>

    @GET("/3/trending/person/week")
    fun getTrendingPerson(@Query("api_key") apiKey: String)
            : Call<TrendingPersonResponseWeekly>

    @GET("/3/{type}/{id}/videos")
    fun getVideo(@Path("type") type: String, @Path("id") id: Long, @Query("api_key") apiKey: String, )
            : Call<VideoResponse>

    @GET("/3/movie/{id}")
    fun getMovieDetails(@Path("id") id: Long, @Query("api_key") apiKey: String, )
            : Call<MovieResponse>

    @GET("/3/{type}/{id}/credits")
    fun getMovieCredits(@Path("type") type: CharSequence, @Path("id") id: Long, @Query("api_key") apiKey: String, )
            : Call<CastCrewResponse>

    @GET("/3/movie/{id}/images")
    fun getMovieImages(@Path("id") id: Long, @Query("api_key") apiKey: String, @Query("include_image_language") lang: String)
            : Call<MovieImageResponses>

    @GET("/3/movie/{id}/recommendations")
    fun getRecommendedMovies(@Path("id") id: Long, @Query("api_key") apiKey: String, )
            : Call<TrendingMovieResponseWeekly>

    @GET("/3/movie/{id}/similar")
    fun getSimilarMovies(@Path("id") id: Long, @Query("api_key") apiKey: String, )
            : Call<TrendingMovieResponseWeekly>

    @GET("/3/tv/{id}/recommendations")
    fun getRecommendedTVs(@Path("id") id: Long, @Query("api_key") apiKey: String )
            : Call<TrendingTVResponseWeekly>

    @GET("/3/tv/{id}/similar")
    fun getSimilarTVs(@Path("id") id: Long, @Query("api_key") apiKey: String )
            : Call<TrendingTVResponseWeekly>

    @GET("/3/tv/{id}")
    fun getTVDetails(@Path("id") id: Long, @Query("api_key") apiKey: String, )
            : Call<TVResponse>

    @GET("/3/person/popular")
    fun getPopularPersons(@Query("api_key") apiKey: String, )
            : Call<PopularPersonResponse>

    @GET("/3/person/{id}/movie_credits")
    fun getMovieOfPerson(@Path("id") id: Long, @Query("api_key") apiKey: String, )
            : Call<PersonMoviesResponse>

    @GET("/3/person/{id}/tv_credits")
    fun getTvOfPerson(@Path("id") id: Long, @Query("api_key") apiKey: String, )
            : Call<PersonTvResponse>

    @GET("/3/person/{id}/tagged_images")
    fun getImagesOfPerson(@Path("id") id: Long, @Query("api_key") apiKey: String, )
            : Call<ImagesOfPersonResponse>

    @GET("/3/person/{id}")
    fun getInfoOfPerson(@Path("id") id: Long, @Query("api_key") apiKey: String, )
            : Call<PersonInfoResponse>

    @GET("/3/search/movie")
    fun searchForMovie(@Query("query") query: String, @Query("api_key") apiKey: String, )
            : Call<MovieSearchResponse>
    @GET("/3/search/tv")
    fun searchForTV(@Query("query") query: String, @Query("api_key") apiKey: String, )
            : Call<TVSearchResponse>
    @GET("/3/search/person")
    fun searchForPerson(@Query("query") query: String, @Query("api_key") apiKey: String, )
            : Call<PersonSearchResponse>


}