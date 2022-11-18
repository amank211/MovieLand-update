package com.pixelpatch.movieland.datamodels.trending

import com.fasterxml.jackson.annotation.JsonProperty

data class TrendingAllResponseWeekly(
    val page: Long,
    val results: List<TrendingAllResultWeekly>,
    @JsonProperty("total_pages")
    val total_pages: Long,
    @JsonProperty("total_results")
    val total_results: Long,
)