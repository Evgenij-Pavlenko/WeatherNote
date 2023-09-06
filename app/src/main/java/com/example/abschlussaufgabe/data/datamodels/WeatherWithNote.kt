package com.example.abschlussaufgabe.data.datamodels

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * Diese Klasse steht für ein Weather with Note
 * @param id der Id
 * @param city der Name des City
 * @param temp die Temp des City
 * @param dt_text die Date-Time des Weather
 * @param note die Note for Weather in Date
 */
@Entity(tableName = "weatherWithNote_table")
data class WeatherWithNote(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    var temp: Float,
    var city: String,
    var dt_txt: String,
    var note: String
)
