package com.example.abschlussaufgabe.data.datamodels

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * Diese Klasse steht für ein Weather
 * @param cityId der Id des City
 * @param name der Name des City
 * @param main die Temp des City
 */
@Entity(tableName = "weather_table")
data class Weather(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    /* val cityId: Int,

    val weatherImg: Int,*/
    val name: String = "",
    val main: MainInWeatherTemp,
    val dt_txt: String = ""

    )
