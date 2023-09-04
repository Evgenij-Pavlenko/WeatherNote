package com.example.abschlussaufgabe.data.datamodels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weatherWithNote_table")
data class WeatherWithNote(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    var weather: Weather,
    var temp: Float,
    var note: String
)
