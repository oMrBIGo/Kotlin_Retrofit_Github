package com.nathit.kotlin_retrofit_github

import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    @GET("users")
    fun getUserData(): Call<List<UserModelItem>>

    @GET("emojis")
    fun getEmojisData(): Call<List<EmojiModelItem>>

}