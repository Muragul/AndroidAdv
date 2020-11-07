package com.example.pagingapplication.service

import com.example.pagingapplication.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    fun getUsers(@Query("page") page:Int):Call<UserResponse>
}
