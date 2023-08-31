package com.example.abschlussaufgabe.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.abschlussaufgabe.data.Repository
import com.example.abschlussaufgabe.data.datamodels.Weather
import com.example.abschlussaufgabe.data.local.getDatabase
import com.example.abschlussaufgabe.data.remote.ApiService
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val repository = Repository(database, ApiService)

    var weatherList = repository.weatherList
    var weather = repository.weather

    private val _complete = MutableLiveData<Boolean>()
    val complete: LiveData<Boolean>
        get() = _complete

    init {
        //
        viewModelScope.launch {
            repository.getWeather("Berlin")
        }
        viewModelScope.launch {
            repository.getCurentWeather("Berlin")
        }
    }

    fun insertWeather(weather: Weather) {
        viewModelScope.launch {
            repository.insert(weather)
            _complete.value = true
        }
    }

    fun updateWeather(weather: Weather) {
        viewModelScope.launch {
            repository.update(weather)
            _complete.value = true
        }
    }

    fun deleteWeather(weather: Weather) {
        viewModelScope.launch {
            Log.e(TAG, "Deleted user with id ${weather.id}")
            repository.delete(weather)
            _complete.value = true
        }
    }

    fun unsetComplete() {
        _complete.value = false
    }
}