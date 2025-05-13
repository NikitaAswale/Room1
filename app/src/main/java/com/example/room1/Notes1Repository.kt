package com.example.room1

import kotlinx.coroutines.flow.Flow

class Notes1Repository(private val notes1Dao: Notes1Dao) {

    suspend fun getAllNotes() : Flow<List<Notes1>> {
        return notes1Dao.getAllNotes()
    }

    suspend fun insert(notes1: Notes1) {
        notes1Dao.insert(notes1)
    }

    suspend fun deleteById(id: Int) {
        notes1Dao.deleteById(id)
    }
}