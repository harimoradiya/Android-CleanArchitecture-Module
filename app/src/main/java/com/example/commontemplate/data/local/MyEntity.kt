package com.example.commontemplate.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "dog_images")
data class MyEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val imageUrl : String
) {

}