package com.pixelpatch.movieland.datamodels.tv

import com.google.gson.annotations.SerializedName

data class TVResponse(
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: Any?,
    @SerializedName("created_by")
    val createdBy: List<CreatedBy>,
    @SerializedName("episode_run_time")
    val episodeRunTime: List<Any?>,
    @SerializedName("first_air_date")
    val firstAirDate: String,
    val genres: List<Genre>,
    val homepage: String,
    val id: Long,
    @SerializedName("in_production")
    val inProduction: Boolean,
    val languages: List<String>,
    @SerializedName("last_air_date")
    val lastAirDate: String,
    @SerializedName("last_episode_to_air")
    val lastEpisodeToAir: LastEpisodeToAir,
    val name: String,
    @SerializedName("next_episode_to_air")
    val nextEpisodeToAir: Any?,
    val networks: List<Network>,
    @SerializedName("number_of_episodes")
    val numberOfEpisodes: Long,
    @SerializedName("number_of_seasons")
    val numberOfSeasons: Long,
    @SerializedName("origin_country")
    val originCountry: List<String>,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_name")
    val originalName: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: Any?,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>,
    @SerializedName("production_countries")
    val productionCountries: List<Any?>,
    val seasons: List<Season>,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val type: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long,
)

data class CreatedBy(
    val id: Long,
    @SerializedName("credit_id")
    val creditId: String,
    val name: String,
    val gender: Long,
    @SerializedName("profile_path")
    val profilePath: String,
)

data class Genre(
    val id: Long,
    val name: String,
)

data class LastEpisodeToAir(
    @SerializedName("air_date")
    val airDate: String,
    @SerializedName("episode_number")
    val episodeNumber: Long,
    val id: Long,
    val name: String,
    val overview: String,
    @SerializedName("production_code")
    val productionCode: String,
    val runtime: Any?,
    @SerializedName("season_number")
    val seasonNumber: Long,
    @SerializedName("show_id")
    val showId: Long,
    @SerializedName("still_path")
    val stillPath: Any?,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long,
)

data class Network(
    val id: Long,
    val name: String,
    @SerializedName("logo_path")
    val logoPath: String,
    @SerializedName("origin_country")
    val originCountry: String,
)

data class ProductionCompany(
    val id: Long,
    @SerializedName("logo_path")
    val logoPath: Any?,
    val name: String,
    @SerializedName("origin_country")
    val originCountry: String,
)

data class Season(
    @SerializedName("air_date")
    val airDate: String,
    @SerializedName("episode_count")
    val episodeCount: Long,
    val id: Long,
    val name: String,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: Any?,
    @SerializedName("season_number")
    val seasonNumber: Long,
)

data class SpokenLanguage(
    @SerializedName("english_name")
    val englishName: String,
    @SerializedName("iso_639_1")
    val iso6391: String,
    val name: String,
)