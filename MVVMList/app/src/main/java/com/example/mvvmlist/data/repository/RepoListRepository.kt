package com.example.mvvmlist.data.repository

import com.example.mvvmlist.data.api.ApiService
import com.example.mvvmlist.data.model.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoListRepository(val apiService: ApiService) {
    fun getRepoList(onResult: (isSuccess: Boolean, response: List<ApiResponse>?) -> Unit) {

        apiService.getRepo().enqueue(object : Callback<List<ApiResponse>> {
            override fun onResponse(
                call: Call<List<ApiResponse>>?,
                response: Response<List<ApiResponse>>?
            ) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body())
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<List<ApiResponse>>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }

}