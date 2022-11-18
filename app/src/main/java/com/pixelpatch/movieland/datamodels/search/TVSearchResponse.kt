package com.pixelpatch.movieland.datamodels.search

import com.google.gson.annotations.SerializedName
import com.pixelpatch.movieland.MediaType
import com.pixelpatch.movieland.ui.adapter.DataModeAssign

data class TVSearchResponse(
    val page: Long,
    val results: List<TVSearchResult>,
    @SerializedName("total_pages")
    val totalPages: Long,
    @SerializedName("total_results")
    val totalResults: Long,
)

data class TVSearchResult(
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("first_air_date")
    val firstAirDate: String,
    @SerializedName("genre_ids")
    val genreIds: List<Long>,
    val id: Long,
    val name: String,
    @SerializedName("origin_country")
    val originCountry: List<String>,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_name")
    val originalName: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long,
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
