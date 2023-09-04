package com.example.abschlussaufgabe.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.abschlussaufgabe.data.datamodels.Weather
import com.example.abschlussaufgabe.data.datamodels.WeatherWithNote

@Dao
interface WeatherWithNoteDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertAll(weatherWithNote: List<WeatherWithNote>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(weatherWithNote: WeatherWithNote)

    @Query("SELECT * FROM weatherWithNote_table")
    fun getAll(): LiveData<List<WeatherWithNote>>

    @Update
    fun update(weatherWithNote: WeatherWithNote)

    @Query("DELETE FROM weatherWithNote_table")
    fun deleteAll()

    @Query("DELETE FROM weatherWithNote_table WHERE id == :idWeather")
    fun deleteById(idWeather:Long)
}