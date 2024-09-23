package com.example.commontemplate.data.repository

import com.example.commontemplate.data.local.MyDao
import com.example.commontemplate.data.local.MyEntity
import com.example.commontemplate.data.remote.MyApiService
import kotlinx.coroutines.flow.Flow

class MyRepository(
private val apiService: MyApiService,
    private val myDao: MyDao

) {

    suspend fun fetchRandomImage() : String{
        val response = apiService.getItemData()
        return response.message
    }

    suspend fun saveImage(imageUrl : String){
        myDao.insertDogImage(MyEntity(imageUrl = imageUrl))
    }

     fun getSavedImage(): Flow<List<MyEntity>> {
        return myDao.getAllDogImages()
    }
}
