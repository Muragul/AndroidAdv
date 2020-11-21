package com.example.mvvmlist.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmlist.data.model.ApiResponse

class GetRepoListUseCase (val repoListRepository: RepoListRepository){
    val repoListLive = MutableLiveData<List<ApiResponse>>()
    fun getRepoList(): LiveData<List<ApiResponse>> {
        return repoListRepository.loadData()
    }
}