package com.pixelpatch.movieland.datamodels.trending

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import com.pixelpatch.movieland.MediaType
import com.pixelpatch.movieland.ui.adapter.DataModeAssign

data class TrendingAllResultWeekly(
    val adult: Boolean,
    @JsonProperty("backdrop_path")
    val backdrop_path: String,
    val id: Long,
    val title: String?,
    @JsonProperty("original_language")
    val original_language: String,
    @JsonProperty("original_title")
    val original_title: String?,
    val overview: String,
    @JsonProperty("poster_path")
    val poster_path: String,
    @JsonProperty("media_type")
    val media_type: String,
    @JsonProperty("genre_ids")
    val genre_ids: List<Long>,
    val popularity: Double,
    @JsonProperty("release_date")
    val release_date: String?,
    val video: Boolean?,
    @JsonProperty("vote_average")
    val vote_average: Double,
    @JsonProperty("vote_count")
    val voteCount: Long,
    val name: String?,
    @SerializedName("original_name")
    val originalName: String?,
    @JsonProperty("first_air_date")
    val first_air_date: String?,
    @JsonProperty("origin_country")
    val origin_country: List<String>?,
) : DataModeAssign {
    override fun getMediaTitle(): String? {
        title?.let { return title }
        originalName?.let { return originalName }
        return null
    }

    override fun getPoster(): String {
        return poster_path
    }

    override fun hasVideo(): Boolean? {
        return video
    }

    override fun getType(): MediaType {
        return MediaType.ALL
    }

    override fun getMediaId(): Long {
        return id
    }
}