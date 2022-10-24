package com.example.movieapplication.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetIMDBClient {
    companion object {
        private val BASE_URL="https://imdb-api.com/API/Ratings/k_yr19dk3j/"

        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }

}