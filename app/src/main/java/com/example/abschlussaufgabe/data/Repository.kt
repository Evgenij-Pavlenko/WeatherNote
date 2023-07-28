package com.example.abschlussaufgabe.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.abschlussaufgabe.data.datamodels.Weather
import com.example.abschlussaufgabe.data.local.WeatherDatabase

const val TAG = "Repository"

class Repository(private val database: WeatherDatabase) {

    val guestList: LiveData<List<Weather>> = database.weatherDatabaseDao.getAll()

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