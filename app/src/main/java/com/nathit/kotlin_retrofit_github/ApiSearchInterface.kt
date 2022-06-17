package com.nathit.kotlin_retrofit_github

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiSearchInterface {

    @GET("search/users")
    @Headers("Authorization: token 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")
    fun loadSearch(
        @Query("q") query: String
    ): Call<List<SearchModel>>

    companion object {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}