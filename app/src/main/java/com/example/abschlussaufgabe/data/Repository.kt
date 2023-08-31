package com.example.abschlussaufgabe.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.abschlussaufgabe.data.datamodels.Weather
import com.example.abschlussaufgabe.data.local.WeatherDatabase
import com.example.abschlussaufgabe.data.remote.API_KEY
import com.example.abschlussaufgabe.data.remote.ApiService

const val TAG = "Repository"

class Repository(private val database: WeatherDatabase, private val api: ApiService) {

   private val _weatherList = MutableLiveData<List<Weather>>()
    val weatherList: LiveData<List<Weather>>
        get() = _weatherList

    private val _weather = MutableLiveData<Weather>()
    val weather: LiveData<Weather>
        get() = _weather

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

    suspend fun insert(weather: Weather) {
        try {
            database.weatherDatabaseDao.insert(weather)
        } catch (e: Exception) {
            Log.e(TAG,"Failed to insert into database: $e")
        }
    }

    suspend fun update(weather: Weather) {
        try {
            database.weatherDatabaseDao.update(weather)
        } catch (e: Exception) {
            Log.e(TAG,"Failed to update database: $e")
        }
    }

    suspend fun delete(weather: Weather) {
        try {
            database.weatherDatabaseDao.deleteById(weather.id)
        } catch (e: Exception) {
            Log.e(TAG, "Failed to delete from database: $e")
        }
    }

}