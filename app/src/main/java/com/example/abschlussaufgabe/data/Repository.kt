package com.example.abschlussaufgabe.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.abschlussaufgabe.data.datamodels.Weather

const val TAG = "Repository"

class Repository(private val database: WeatherDatabase) {

    val guestList: LiveData<List<Weather>> = database.guestDatabaseDao.getAll()

    suspend fun insert(guest: Weather) {
        try {
            database.guestDatabaseDao.insert(guest)
        } catch (e: Exception) {
            Log.e(TAG,"Failed to insert into database: $e")
        }
    }

    suspend fun update(guest: Weather) {
        try {
            database.guestDatabaseDao.update(guest)
        } catch (e: Exception) {
            Log.e(TAG,"Failed to update database: $e")
        }
    }

    suspend fun delete(weather: Weather) {
        try {
            database.guestDatabaseDao.deleteById(weather.id)
        } catch (e: Exception) {
            Log.e(TAG, "Failed to delete from database: $e")
        }
    }

}