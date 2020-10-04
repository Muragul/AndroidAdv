package com.example.mvvmlist.di

import org.koin.dsl.module
import android.content.SharedPreferences
import com.example.mvvmlist.data.api.ApiClient
import com.example.mvvmlist.data.repository.RepoListRepository
import com.example.mvvmlist.viewmodel.RepoListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule = module {
    viewModel { RepoListViewModel(get()) }
}

val repositoryModule = module {
    single { RepoListRepository(get()) }
}

val networkModule = module {
    single { ApiClient.create(okHttpClient = get()) }
    single { ApiClient.getOkHttpClient(authInterceptor = get()) }
    single { ApiClient.getAuthInterceptor(sharedPreferences = get()) }
}
val sharedPrefModule = module {
    single {
        androidApplication().getSharedPreferences("default", android.content.Context.MODE_PRIVATE)
    }

    single<SharedPreferences.Editor> {
        androidApplication().getSharedPreferences("default", android.content.Context.MODE_PRIVATE)
            .edit()
    }
}