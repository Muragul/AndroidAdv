package com.example.mvvmlist.data.api

import com.example.mvvmlist.data.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    fun getRepo(): Call<List<ApiResponse>>
}
