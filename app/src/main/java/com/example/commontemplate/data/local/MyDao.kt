package com.example.commontemplate.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDogImage(dogImage: MyEntity)

    @Query("SELECT * FROM dog_images")
    fun getAllDogImages(): Flow<List<MyEntity>>

}
