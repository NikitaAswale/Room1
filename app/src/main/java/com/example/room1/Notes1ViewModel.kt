package com.example.room1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class Notes1ViewModel(application : Application) : AndroidViewModel(application) {

    private val database =(application as Notes1Application).database

    //Repository instance
    val repository by lazy {
        Notes1Repository(database.notes1Dao())
    }
    private val _notes: MutableStateFlow<List<Notes1>> = MutableStateFlow(emptyList())
    val notes1 : StateFlow<List<Notes1>> = _notes

    init {
        getAllNotes()
    }

    private fun getAllNotes() {
        viewModelScope.launch {
            repository.getAllNotes().collect {
                _notes.value = it
            }
        }
    }

    fun addNote(title: String) {
        viewModelScope.launch {
            if (title.isNotEmpty()) {
                repository.insert(
                    Notes1(
                        title = title
                    )
                )
            }
        }
    }

    fun deleteNote(id: Int) {
        viewModelScope.launch {
            repository.deleteById(id)
        }
    }
}