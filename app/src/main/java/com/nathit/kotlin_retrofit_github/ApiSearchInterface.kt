package com.nathit.kotlin_retrofit_github

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiSearchInterface {

    @GET("users")
    fun loadRepos(
        @Query("q") q: String?
    ): Call<List<ReposModel>>

    companion object {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/search")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}