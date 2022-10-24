package com.example.movieapplication.retrofit

import com.example.movieapplication.models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GetMovieInterface {
    @GET("movie/top_rated")
    fun getTopRated(@Query("api_key")apiKey:String): Call<TopMovie>

    @GET("/genre/movie/list")
    fun getAllGenres(@Query("api_key")apiKey:String): Call<GeneresModel>

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key")apiKey:String): Call<PopularMovie>

    @GET("{id}")
    fun getRating(@Path("id") id :String):Call<IMDBRatingModel>

    @GET("movie/{id}")
    fun getMovieDetails(

        @Path("id") id :Int,
        @Query("api_key")apiKey:String
    ):Call<MovieDetail>




}