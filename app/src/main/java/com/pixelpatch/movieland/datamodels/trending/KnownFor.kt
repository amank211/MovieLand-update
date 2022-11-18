package com.pixelpatch.movieland.datamodels.trending

import com.fasterxml.jackson.annotation.JsonProperty

data class KnownFor(
    val adult: Boolean,
    @JsonProperty("backdrop_path")
    val backdrop_path: String?,
    val id: Long,
    val title: String,
    @JsonProperty("original_language")
    val original_language: String,
    @JsonProperty("original_title")
    val original_title: String,
    val overview: String,
    @JsonProperty("poster_path")
    val poster_path: String,
    @JsonProperty("media_type")
    val media_type: String,
    @JsonProperty("genre_ids")
    val genre_ids: List<Long>,
    val popularity: Double,
    @JsonProperty("release_date")
    val release_date: String,
    val video: Boolean,
    @JsonProperty("vote_average")
    val vote_average: Double,
    @JsonProperty("vote_count")
    val vote_count: Long,
)