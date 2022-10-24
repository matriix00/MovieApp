package com.example.movieapplication.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class IMDBRatingModel(

    @Expose
    @SerializedName("imDbId")
    val imDbId: String,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("fullTitle")
    val fullTitle: String,
    @Expose
    @SerializedName("type")
    val type: String,
    @Expose
    @SerializedName("year")
    val year: String,
    @Expose
    @SerializedName("imDb")
    val imDb: String,
    @Expose
    @SerializedName("metacritic")
    val metacritic: String,
    @Expose
    @SerializedName("theMovieDb")
    val theMovieDb: String,
    @Expose
    @SerializedName("rottenTomatoes")
    val rottenTomatoes: String,
    @Expose
    @SerializedName("filmAffinity")
    val filmAffinity: String,
    @Expose
    @SerializedName("errorMessage")
    val errorMessage: String
)
