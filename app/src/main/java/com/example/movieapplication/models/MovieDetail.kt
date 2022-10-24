package com.example.movieapplication.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieDetail(

    @Expose
    @SerializedName("adult")
    var adult: Boolean,
    @Expose
    @SerializedName("backdrop_path")
    val backdrop_path: String,
    @Expose
    @SerializedName("budget")
    var budget: Int,
    @Expose
    @SerializedName("genres")
    var genresEntity: List<GenresEntity>,
    @Expose
    @SerializedName("homepage")
    val homepage: String,
    @Expose
    @SerializedName("id")
    var id: Int,
    @Expose
    @SerializedName("imdb_id")
    val imdb_id: String,
    @Expose
    @SerializedName("original_language")
    val original_language: String,
    @Expose
    @SerializedName("original_title")
    val original_title: String,
    @Expose
    @SerializedName("overview")
    val overview: String,
    @Expose
    @SerializedName("popularity")
    val popularity: Double,
    @Expose
    @SerializedName("poster_path")
    val poster_path: String,
    @Expose
    @SerializedName("production_companies")
    var production_companiesEntity: List<Production_companiesEntity>,
    @Expose
    @SerializedName("production_countries")
    var production_countriesEntity: List<Production_countriesEntity>,
    @Expose
    @SerializedName("release_date")
    val release_date: String,
    @Expose
    @SerializedName("revenue")
    var revenue: Int,
    @Expose
    @SerializedName("runtime")
    var runtime: Int,
    @Expose
    @SerializedName("spoken_languages")
    var spoken_languagesEntity: List<Spoken_languagesEntity>,
    @Expose
    @SerializedName("status")
    val status: String,
    @Expose
    @SerializedName("tagline")
    val tagline: String,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("video")
    var video: Boolean,
    @Expose
    @SerializedName("vote_average")
    val vote_average: Double,
    @Expose
    @SerializedName("vote_count")
    var vote_count: Int
)

data class Spoken_languagesEntity(
    @Expose
    @SerializedName("english_name")
    val english_name: String,
    @Expose
    @SerializedName("iso_639_1")
    val iso_639_1: String,
    @Expose
    @SerializedName("name")
    val name: String
)

data class Production_countriesEntity(
    @Expose
    @SerializedName("iso_3166_1")
    val iso_3166_1: String,
    @Expose
    @SerializedName("name")
    val name: String
)

data class Production_companiesEntity(
    @Expose
    @SerializedName("id")
    var id: Int,
    @Expose
    @SerializedName("logo_path")
    val logo_path: String,
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("origin_country")
    val origin_country: String
)

data class GenresEntity(
    @Expose
    @SerializedName("id")
    var id: Int,
    @Expose
    @SerializedName("name")
    val name: String
)
