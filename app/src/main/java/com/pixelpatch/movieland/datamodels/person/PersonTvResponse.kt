package com.pixelpatch.movieland.datamodels.person

import com.google.gson.annotations.SerializedName
import com.pixelpatch.movieland.MediaType
import com.pixelpatch.movieland.ui.adapter.DataModeAssign

data class PersonTvResponse(
    val cast: List<TVCast>,
    val crew: List<TVCrew>,
    val id: Long,
)

data class TVCast(
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("genre_ids")
    val genreIds: List<Long>,
    val id: Long,
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
    @SerializedName("first_air_date")
    val firstAirDate: String,
    val name: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long,
    val character: String,
    @SerializedName("credit_id")
    val creditId: String,
    @SerializedName("episode_count")
    val episodeCount: Long,
) : DataModeAssign {
    override fun getMediaTitle(): String? {
        name?.let { return name }
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

data class TVCrew(
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Long>,
    val id: Long,
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
    @SerializedName("first_air_date")
    val firstAirDate: String,
    val name: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long,
    @SerializedName("credit_id")
    val creditId: String,
    val department: String,
    @SerializedName("episode_count")
    val episodeCount: Long,
    val job: String,
) : DataModeAssign {
    override fun getMediaTitle(): String? {
        name?.let { return name }
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
