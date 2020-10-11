package com.example.mvvmlist.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmlist.data.api.ApiService
import com.example.mvvmlist.data.model.ApiResponse
import retrofit2.HttpException
import retrofit2.Response
import kotlinx.coroutines.*
import timber.log.Timber

abstract class BaseDataStore(@PublishedApi internal val service: ApiService) {

    abstract fun loadData(): LiveData<List<ApiResponse>>


    inline fun fetchData(crossinline call: (ApiService) -> Deferred<Response<List<ApiResponse>>>): LiveData<List<ApiResponse>> {
        val result = MutableLiveData<List<ApiResponse>>()
        CoroutineScope(Dispatchers.IO).launch {
            val request = call(service)
            withContext(Dispatchers.Main) {
                try {
                    val response = request.await()
                    if (response.isSuccessful) {
                        result.value = response.body()
                    } else {
                        Timber.d("Error occurred with code ${response.code()}")
                    }
                } catch (e: HttpException) {
                    Timber.d("Error: ${e.message()}")
                } catch (e: Throwable) {
                    Timber.d("Error: ${e.message}")
                }
            }
        }

        return result
    }


}