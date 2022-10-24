package com.example.movieapplication.retrofit

import com.example.movieapplication.constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetMovieClientService {
    companion object {
        private val BASE_URL="https://api.themoviedb.org/3/"

        fun getInstance():Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }
}