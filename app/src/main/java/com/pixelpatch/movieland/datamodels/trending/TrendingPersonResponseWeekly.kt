package com.pixelpatch.movieland.datamodels.trending

import com.fasterxml.jackson.annotation.JsonProperty

data class TrendingPersonResponseWeekly(
    val page: Long,
    val results: List<TrendingPersonResultWeekly>,
    @JsonProperty("total_pages")
    val total_pages: Long,
    @JsonProperty("total_results")
    val total_Results: Long,
)