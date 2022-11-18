package com.pixelpatch.movieland.datamodels.movie

import com.google.gson.annotations.SerializedName

data class MovieImageResponses(
    val backdrops: List<Backdrop>,
    val id: Long,
    val logos: List<Logo>,
    val posters: List<Poster>,
)

data class Backdrop(
    @SerializedName("aspect_ratio")
    val aspectRatio: Double,
    val height: Long,
    @SerializedName("iso_639_1")
    val iso6391: String,
    @SerializedName("file_path")
    val filePath: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long,
    val width: Long,
)

data class Logo(
    @SerializedName("aspect_ratio")
    val aspectRatio: Double,
    val height: Long,
    @SerializedName("iso_639_1")
    val iso6391: String,
    @SerializedName("file_path")
    val filePath: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long,
    val width: Long,
)

data class Poster(
    @SerializedName("aspect_ratio")
    val aspectRatio: Double,
    val height: Long,
    @SerializedName("iso_639_1")
    val iso6391: String,
    @SerializedName("file_path")
    val filePath: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long,
    val width: Long,
)
