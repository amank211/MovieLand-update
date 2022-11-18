package com.pixelpatch.movieland.datamodels.movie

import com.google.gson.annotations.SerializedName
import com.pixelpatch.movieland.MediaType
import com.pixelpatch.movieland.ui.adapter.DataModeAssign

data class CastCrewResponse(
    val id: Long,
    val cast: List<Cast>,
    val crew: List<Crew>,
)

data class Cast(
    val adult: Boolean,
    val gender: Long,
    val id: Long,
    @SerializedName("known_for_department")
    val knownForDepartment: String,
    val name: String,
    @SerializedName("original_name")
    val originalName: String,
    val popularity: Double,
    @SerializedName("profile_path")
    val profilePath: String,
    @SerializedName("cast_id")
    val castId: Long,
    val character: String,
    @SerializedName("credit_id")
    val creditId: String,
    val order: Long,
) : DataModeAssign {
    override fun getMediaTitle(): String? {
        return name
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

data class Crew(
    val adult: Boolean,
    val gender: Long,
    val id: Long,
    @SerializedName("known_for_department")
    val knownForDepartment: String,
    val name: String,
    @SerializedName("original_name")
    val originalName: String,
    val popularity: Double,
    @SerializedName("profile_path")
    val profilePath: String,
    @SerializedName("credit_id")
    val creditId: String,
    val department: String,
    val job: String,
) : DataModeAssign {
    override fun getMediaTitle(): String? {
        return name
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