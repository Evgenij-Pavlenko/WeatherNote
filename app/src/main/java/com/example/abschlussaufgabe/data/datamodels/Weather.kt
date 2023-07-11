package com.example.abschlussaufgabe.data.datamodels

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Diese Klasse steht für ein Weather
 * @param cityId der Id des City
 * @param city der Name des City
 * @param temp die die Temp des City
 */
@Entity(tableName = "weather_table")
data class Weather(

    @PrimaryKey(autoGenerate = true)
    private val id: Long = 0,
    private val cityId: Int,
    val city: String,
    val temp: Float,

    )
