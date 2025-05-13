package com.example.room1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes1" )
data class Notes1(
    @PrimaryKey(autoGenerate = true)
    val id :Int = 0,
    val title : String
)
