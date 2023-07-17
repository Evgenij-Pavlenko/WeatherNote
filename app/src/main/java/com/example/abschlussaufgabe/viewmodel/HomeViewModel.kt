package com.example.abschlussaufgabe.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val  database = getDatabase(application)
    private val repository = Repository(database)

    val guestList = repository.guestList

    private val _complete = MutableLiveData<Boolean>()
    val complete: LiveData<Boolean>
        get() = _complete

    fun insertGuest(guest: Guest) {
        viewModelScope.launch {
            repository.insert(guest)
            _complete.value = true
        }
    }

    fun updateGuest(guest: Guest) {
        viewModelScope.launch {
            repository.update(guest)
            _complete.value = true
        }
    }

    fun deleteGuest(guest: Guest) {
        viewModelScope.launch {
            Log.e("MainViewModel", "Deleted user with id ${guest.id}")
            repository.delete(guest)
            _complete.value = true
        }
    }

    fun unsetComplete() {
        _complete.value = false
    }
}