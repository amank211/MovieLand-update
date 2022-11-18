package com.pixelpatch.movieland.datamodels.trending

import com.google.gson.annotations.SerializedName
import com.pixelpatch.movieland.MediaType
import com.pixelpatch.movieland.ui.adapter.DataModeAssign

data class TrendingTVResultWeekly(
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    val id: Long,
    val name: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_name")
    val originalName: String,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("genre_ids")
    val genreIds: List<Long>,
    val popularity: Double,
    @SerializedName("first_air_date")
    val firstAirDate: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long,
    @SerializedName("origin_country")
    val originCountry: List<String>,
) : DataModeAssign {
    override fun getMediaTitle(): String? {
        originalName?.let { return originalName }
        return null
    }

    override fun getPoster(): String {
        return posterPath
    }

    override fun hasVideo(): Boolean? {
        return false
    }

    override fun getType(): MediaType {
        return MediaType.TV
    }

    override fun getMediaId(): Long {
        return id
    }
}