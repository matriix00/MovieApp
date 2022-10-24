package com.example.movieapplication.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PopularMovie(
    @Expose
    @SerializedName("page")
    val page: Int,
    @Expose
    @SerializedName("results")
    val resultsEntity: List<PopularResults>,
    @Expose
    @SerializedName("total_pages")
    val total_pages: Int,
    @Expose
    @SerializedName("total_results")
    val total_results: Int
)

