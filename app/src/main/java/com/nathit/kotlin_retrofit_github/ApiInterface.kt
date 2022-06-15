package com.nathit.kotlin_retrofit_github

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {

    @GET("users")
    fun getUserData(): Call<List<UserModelItem>>

    @GET("repositories")
    fun getDataFromAPI(@Query("q")query : String):Call<UserModelItem>

}