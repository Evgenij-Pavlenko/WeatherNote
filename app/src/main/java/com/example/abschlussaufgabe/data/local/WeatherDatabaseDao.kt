package com.example.abschlussaufgabe.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.abschlussaufgabe.data.datamodels.Weather
import retrofit2.http.DELETE

@Dao
interface WeatherDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(weathers: List<Weather>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weather: Weather)

    @Query("SELECT * FROM weather_table")
    fun getAll(): LiveData<List<Weather>>

    @Update
    fun update(weather: Weather)

    @Query("DELETE FROM weather_table")
    fun deleteAll()

//    @Query("DELETE id FROM weather_table")
    @Query("DELETE FROM weather_table WHERE id == :idWeather")
    fun deleteById(idWeather:Long)
}