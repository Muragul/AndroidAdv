package com.example.mvvmlist.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.mvvmlist.data.model.ApiResponse
import com.example.mvvmlist.data.repository.RepoListRepository

class RepoListViewModel(private val repoListRepository: RepoListRepository) : BaseViewModel() {
    val repoListLive = MutableLiveData<List<ApiResponse>>()

    fun fetchRepoList() {
        dataLoading.value = true
        repoListRepository.getRepoList { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                repoListLive.value = response
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }
}