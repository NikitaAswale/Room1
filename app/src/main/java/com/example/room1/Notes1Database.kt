package com.example.room1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Notes1::class], version = 1)
abstract class Notes1Database : RoomDatabase() {
    abstract fun notes1Dao(): Notes1Dao

    companion object {
        @Volatile private var INSTANCE: Notes1Database? = null

        fun getDatabase(context: Context): Notes1Database {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    Notes1Database::class.java,
                    "notes1_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}