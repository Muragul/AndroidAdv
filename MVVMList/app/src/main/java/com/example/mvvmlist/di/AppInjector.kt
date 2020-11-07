package com.example.mvvmlist.di

import android.app.Application
import org.koin.dsl.module
import android.content.SharedPreferences
import androidx.room.Room
import com.example.mvvmlist.data.api.ApiClient
import com.example.mvvmlist.data.repository.RepoListDataStore
import com.example.mvvmlist.db.PostDao
import com.example.mvvmlist.db.PostDatabase
import com.example.mvvmlist.domain.GetRepoListUseCase
import com.example.mvvmlist.viewmodel.RepoListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule = module {
    viewModel { RepoListViewModel(get()) }
}
val useCaseModule = module {
    single { GetRepoListUseCase(get<RepoListDataStore>()) }
}

val repositoryModule = module {
    single { RepoListDataStore(get(), get()) }
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
val databaseModule = module {
    fun provideDatabase(application: Application): PostDatabase {
        return Room.databaseBuilder(
            application,
            PostDatabase::class.java,
            "posts_database.db"
        ).allowMainThreadQueries()
            .build()
    }

    fun provideDao(database: PostDatabase): PostDao {
        return database.postDao()
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
}