package com.example.room1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Notes1Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(notes1: Notes1)

    @Query("SELECT * FROM notes1 ORDER BY id ASC")
    fun getAllNotes(): Flow<List<Notes1>>

    @Query("DELETE FROM notes1 WHERE id = :id")
    suspend fun deleteById(id: Int)
}