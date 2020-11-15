package com.example.mvvmlist.data.repository

import androidx.lifecycle.LiveData
import com.example.mvvmlist.data.api.ApiService
import com.example.mvvmlist.data.model.ApiResponse
import com.example.mvvmlist.db.PostDao
import com.example.mvvmlist.domain.RepoListRepository

class RepoListDataStore(apiService: ApiService, postDao: PostDao) : RepoListRepository,
    BaseDataStore(apiService, postDao) {

    override fun loadData(): LiveData<List<ApiResponse>> {
        return fetchData { service.getRepo() }
    }
}