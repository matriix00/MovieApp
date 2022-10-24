package com.example.movieapplication.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GeneresModel(
    @Expose
    @SerializedName("genres")
    val genresList: List<GeneresResults>
)

