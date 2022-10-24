package com.example.movieapplication.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TopMovie(


    @Expose
    @SerializedName("page")
    val page: Int,
    @Expose
    @SerializedName("results")
    val results: List<MovieResults>,
    @Expose
    @SerializedName("total_pages")
    val total_pages: Int,

    @Expose
    @SerializedName("total_results")
    val total_results: Int
)


