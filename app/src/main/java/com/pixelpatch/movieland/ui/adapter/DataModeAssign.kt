package com.pixelpatch.movieland.ui.adapter

import com.pixelpatch.movieland.MediaType

interface DataModeAssign {
    fun getMediaTitle(): String?
    fun getPoster(): String
    fun hasVideo(): Boolean?
    fun getType(): MediaType
    fun getMediaId(): Long
}