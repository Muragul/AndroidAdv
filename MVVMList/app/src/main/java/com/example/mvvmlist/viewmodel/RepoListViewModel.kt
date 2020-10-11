package com.example.mvvmlist.viewmodel

import androidx.lifecycle.LiveData
import com.example.mvvmlist.data.model.ApiResponse
import com.example.mvvmlist.domain.GetRepoListUseCase

class RepoListViewModel(val getRepoListUseCase: GetRepoListUseCase) : BaseViewModel() {
    fun fetchRepoList(): LiveData<List<ApiResponse>> {
        return getRepoListUseCase.getRepoList()
    }
}