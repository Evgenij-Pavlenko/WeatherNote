package com.example.abschlussaufgabe.data.datamodels

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "weatherWithNote_table")
data class WeatherWithNote(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
//    var weather: Weather,
    var temp: Float,
    var city: String,
    var dt_txt: String,
    var note: String
)
