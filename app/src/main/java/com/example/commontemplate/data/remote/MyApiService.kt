package com.example.commontemplate.data.remote

import com.example.commontemplate.data.model.MyApiResponse
import retrofit2.http.GET

interface MyApiService {

    @GET("breeds/image/random")
    suspend fun getItemData() : MyApiResponse
}