package com.pixelpatch.movieland.datamodels.search

import com.google.gson.annotations.SerializedName
import com.pixelpatch.movieland.MediaType
import com.pixelpatch.movieland.ui.adapter.DataModeAssign


data class MovieSearchResponse(
    val page: Long,
    val results: List<MovieSearchResult>,
    @SerializedName("total_pages")
    val totalPages: Long,
    @SerializedName("total_results")
    val totalResults: Long,
)

data class MovieSearchResult(
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("genre_ids")
    val genreIds: List<Long>,
    val id: Long,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String?,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long,
) : DataModeAssign {
    override fun getMediaTitle(): String? {
        title.let { return title }
    }

    override fun getPoster(): String {
        return posterPath
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
