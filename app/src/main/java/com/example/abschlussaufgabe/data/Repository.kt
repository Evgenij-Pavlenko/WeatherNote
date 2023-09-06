package com.example.abschlussaufgabe.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.abschlussaufgabe.data.datamodels.Weather
import com.example.abschlussaufgabe.data.datamodels.WeatherWithNote
import com.example.abschlussaufgabe.data.local.WeatherWithNoteDatabase
import com.example.abschlussaufgabe.data.remote.ApiService
import com.example.abschlussaufgabe.helper.API_KEY

const val TAG = "Repository"

class Repository(private val database: WeatherWithNoteDatabase, private val api: ApiService) {

    private val _weatherList = MutableLiveData<List<Weather>>()

    val weatherList: LiveData<List<Weather>>
        get() = _weatherList

    private val _weather = MutableLiveData<Weather>()
    val weather: LiveData<Weather>
        get() = _weather

    private val _weatherListWithNote = MutableLiveData<List<WeatherWithNote>>()
    val weatherListWithNote: LiveData<List<WeatherWithNote>>
        get() = _weatherListWithNote

    private val _weatherWithNote = MutableLiveData<WeatherWithNote>()
    val weatherWithNote: LiveData<WeatherWithNote>
        get() = _weatherWithNote

    suspend fun getCurentWeather(city: String) {
        try {
            _weather.value = api.retrofitService.getCurentWeather(city, API_KEY)
        } catch (e: Exception) {
            Log.e("AppRepository", "Fehler beim Daten laden: $e")
        }
    }

    suspend fun getWeather(city: String) {
        try {
            _weatherList.value = api.retrofitService.getWeather(city, API_KEY).list
        } catch (e: Exception) {
            Log.e("AppRepository", "Fehler beim Daten laden: $e")
        }
    }

    suspend fun getWeatherWithNote() {
        try {
            _weatherListWithNote.value = database.weatherWithNoteDatabaseDao.getAll()
        } catch (e: Exception) {
            Log.e("AppRepository", "Fehler beim Daten laden: $e")
        }
    }

    suspend fun insert(weatherWithNote: WeatherWithNote) {
        try {
            Log.e(TAG, "INSERT")
            database.weatherWithNoteDatabaseDao.insert(weatherWithNote)
        } catch (e: Exception) {
            Log.e(TAG, "Failed to insert into database: $e")
        }
    }

    suspend fun update(weatherWithNote: WeatherWithNote) {
        try {
            database.weatherWithNoteDatabaseDao.update(weatherWithNote)
        } catch (e: Exception) {
            Log.e(TAG, "Failed to update database: $e")
        }
    }

    suspend fun delete(weatherWithNote: WeatherWithNote) {
        try {
            database.weatherWithNoteDatabaseDao.deleteWeatherWithNote(weatherWithNote)
        } catch (e: Exception) {
            Log.e(TAG, "Failed to delete from database: $e")
        }
    }

}