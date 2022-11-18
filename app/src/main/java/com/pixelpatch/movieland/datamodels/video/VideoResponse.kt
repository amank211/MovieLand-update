package com.pixelpatch.movieland.datamodels.video

data class VideoResponse(
    val id: Long,
    val results: List<VideoResult>,
)