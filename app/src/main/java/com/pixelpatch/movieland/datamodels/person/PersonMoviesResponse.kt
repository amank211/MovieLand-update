package com.pixelpatch.movieland.datamodels.person

import com.google.gson.annotations.SerializedName
import com.pixelpatch.movieland.MediaType
import com.pixelpatch.movieland.ui.adapter.DataModeAssign

data class PersonMoviesResponse(
    val cast: List<Cast>,
    val crew: List<Crew>,
    val id: Long,
)

data class Cast(
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
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long,
    val character: String,
    @SerializedName("credit_id")
    val creditId: String,
    val order: Long,
) : DataModeAssign {
    override fun getMediaTitle(): String? {
        title?.let { return title }
        return null
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

data class Crew(
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
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long,
    @SerializedName("credit_id")
    val creditId: String,
    val department: String,
    val job: String,
) : DataModeAssign {
    override fun getMediaTitle(): String? {
        title?.let { return title }
        return null
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
