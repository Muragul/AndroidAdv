package com.example.mvvmlist.domain

import androidx.lifecycle.LiveData
import com.example.mvvmlist.data.model.ApiResponse


interface RepoListRepository {
    fun loadData(): LiveData<List<ApiResponse>>
}