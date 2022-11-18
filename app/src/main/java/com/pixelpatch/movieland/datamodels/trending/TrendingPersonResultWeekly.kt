package com.pixelpatch.movieland.datamodels.trending

import com.fasterxml.jackson.annotation.JsonProperty
import com.pixelpatch.movieland.MediaType
import com.pixelpatch.movieland.ui.adapter.DataModeAssign

data class TrendingPersonResultWeekly(
    val adult: Boolean,
    val id: Long,
    val name: String,
    @JsonProperty("original_name")
    val original_name: String,
    @JsonProperty("media_type")
    val media_type: String,
    val popularity: Double,
    val gender: Long,
    @JsonProperty("known_for_department")
    val known_for_department: String,
    @JsonProperty("profile_path")
    val profile_path: String,
    @JsonProperty("known_for")
    val known_for: List<KnownFor>,
) : DataModeAssign {
    override fun getMediaTitle(): String? {
        return name
    }

    override fun getPoster(): String {
        return profile_path
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