package com.pixelpatch.movieland.datamodels.trending

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import com.pixelpatch.movieland.MediaType
import com.pixelpatch.movieland.ui.adapter.DataModeAssign

data class TrendingMovieResultWeekly(
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    val id: Long,
    val title: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val original_title: String,
    val overview: String,
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("media_type")
    val media_type: String,
    @SerializedName("genre_ids")
    val genre_ids: List<Long>,
    val popularity: Double,
    @SerializedName("release_date")
    val release_date: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long,
) : DataModeAssign {
    override fun getMediaTitle(): String? {
        title?.let { return title }
        return null
    }

    override fun getPoster(): String {
        return poster_path
    }

    override fun hasVideo(): Boolean? {
        return video
    }

    override fun getType(): MediaType {
        return MediaType.MOVIE
    }

    override fun getMediaId(): Long {
        return id
    }
}