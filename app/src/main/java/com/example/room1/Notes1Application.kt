package com.example.room1

import android.app.Application

class Notes1Application : Application() {
    // Lazy initialization of database
    val database by lazy {
        Notes1Database.getDatabase(this)
    }
}