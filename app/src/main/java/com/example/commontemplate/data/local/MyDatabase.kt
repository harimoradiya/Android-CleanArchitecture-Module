package com.example.commontemplate.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [MyEntity::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun myDao(): MyDao
}