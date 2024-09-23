package com.example.commontemplate.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.commontemplate.data.local.MyDatabase
import com.example.commontemplate.data.remote.MyApiService
import com.example.commontemplate.data.repository.MyRepository
import com.example.commontemplate.presentation.viewmodel.MyViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.sin


val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApiService::class.java)
    }

    single {
        Room.databaseBuilder(androidApplication(), MyDatabase::class.java,"my-databse")
            .fallbackToDestructiveMigration()
            .build()

    }

    single { get<MyDatabase>().myDao() }

    single{MyRepository(get(),get())}

    viewModel { MyViewModel(get()) }

}