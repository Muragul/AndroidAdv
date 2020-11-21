package com.example.mvvmlist.data.api

import com.example.mvvmlist.data.model.ApiResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    fun getRepo(): Deferred<Response<List<ApiResponse>>>
}
