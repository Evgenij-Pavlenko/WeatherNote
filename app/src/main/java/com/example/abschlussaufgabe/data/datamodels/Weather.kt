package com.example.abschlussaufgabe.data.datamodels

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.material.circularreveal.CircularRevealHelper.Strategy
import java.util.Date

/**
 * Diese Klasse steht für ein Weather
 * @param id der Id
 * @param name der Name des City
 * @param main die Temp des City
 * @param dt_text date des weather
 */
@Entity(tableName = "weather_table")
data class Weather(

    //initialisiert, weil 2 API and one have parameter, another dont
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    var name: String = "",
    val main: MainInWeatherTemp,
    var dt_txt: String = ""

)
