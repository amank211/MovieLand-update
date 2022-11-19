package com.pixelpatch.movieland.datamodels.search

import com.google.gson.annotations.SerializedName
import com.pixelpatch.movieland.MediaType
import com.pixelpatch.movieland.ui.adapter.DataModeAssign


data class PersonSearchResponse(
    val page: Long,
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Long,
    @SerializedName("total_results")
    val totalResults: Long,
)

data class Result(
    val adult: Boolean,
    val gender: Long,
    val id: Long,
    @SerializedName("known_for")
    val knownFor: List<KnownFor>,
    @SerializedName("known_for_department")
    val knownForDepartment: String,
    val name: String,
    val popularity: Double,
    @SerializedName("profile_path")
    val profilePath: String,
) : DataModeAssign {
    override fun getMediaTitle(): String? {
        name?.let { return name }
        return null
    }

    override fun getPoster(): String {
        return profilePath
    }

    override fun hasVideo(): Boolean? {
        return false
    }

    override fun getType(): MediaType {
        return MediaType.PERSON
    }

    override fun getMediaId(): Long {
        return id
    }
}

data class KnownFor(
    val adult: Boolean?,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Long>,
    val id: Long,
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String?,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String?,
    val title: String?,
    val video: Boolean?,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long,
    @SerializedName("first_air_date")
    val firstAirDate: String?,
    val name: String?,
    @SerializedName("origin_country")
    val originCountry: List<String>?,
    @SerializedName("original_name")
    val originalName: String?,
)
