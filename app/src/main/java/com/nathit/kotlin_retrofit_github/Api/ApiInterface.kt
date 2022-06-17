package com.nathit.kotlin_retrofit_github.Api

import com.nathit.kotlin_retrofit_github.Model.UserModel
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    @GET("users")
    fun getUserData(): Call<List<UserModel>>

}