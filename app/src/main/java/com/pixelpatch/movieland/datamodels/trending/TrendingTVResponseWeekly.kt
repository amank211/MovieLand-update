package com.pixelpatch.movieland.datamodels.trending

import com.fasterxml.jackson.annotation.JsonProperty

data class TrendingTVResponseWeekly(
    val page: Long,
    val results: List<TrendingTVResultWeekly>,
    @JsonProperty("total_pages")
    val total_pages: Long,
    @JsonProperty("total_results")
    val total_Results: Long,
)