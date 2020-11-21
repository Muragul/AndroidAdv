package com.example.pagingapplication.datasource

import androidx.paging.PageKeyedDataSource
import com.example.pagingapplication.model.User
import com.example.pagingapplication.model.UserResponse
import com.example.pagingapplication.service.ApiService
import com.example.pagingapplication.service.ApiServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserDataSource : PageKeyedDataSource<Int, User>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, User>
    ) {

        val service = ApiServiceBuilder.buildService(ApiService::class.java)
        val call = service.getUsers(FIRST_PAGE)

        call.enqueue(object : Callback<UserResponse>{
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if(response.isSuccessful){
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.users

                    responseItems?.let {
                        callback.onResult(responseItems,null, FIRST_PAGE+1)
                    }
                }

            }

        })

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        val service = ApiServiceBuilder.buildService(ApiService::class.java)
        val call = service.getUsers(params.key)

        call.enqueue(object : Callback<UserResponse>{
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if(response.isSuccessful){
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.users

                    val key = params.key + 1

                    responseItems?.let {
                        callback.onResult(responseItems,key)
                    }
                }

            }

        })

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        val service = ApiServiceBuilder.buildService(ApiService::class.java)
        val call = service.getUsers(params.key)

        call.enqueue(object : Callback<UserResponse>{
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if(response.isSuccessful){
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.users

                    val key = if (params.key >1 )params.key -1 else 0

                    responseItems?.let {
                        callback.onResult(responseItems,key)
                    }
                }

            }

        })

    }

    companion object{
        const val PAGE_SIZE = 3
        const val FIRST_PAGE = 1

    }
}