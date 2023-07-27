package com.example.abschlussaufgabe.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.abschlussaufgabe.data.datamodels.Weather

@Dao
interface WeatherDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(weathers: List<Weather>)

    @Query("SELECT * FROM weather_table")
    fun getAll(): LiveData<List<Weather>>

    @Query("DELETE FROM weather_table")
    fun deleteAll()
}