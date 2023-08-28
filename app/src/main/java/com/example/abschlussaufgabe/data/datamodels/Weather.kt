package com.example.abschlussaufgabe.data.datamodels

import android.icu.util.LocaleData
import android.provider.ContactsContract.Data
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.Date

/**
 * Diese Klasse steht für ein Weather
 * @param cityId der Id des City
 * @param city der Name des City
 * @param temp die die Temp des City
 */
@Entity(tableName = "weather_table")
data class Weather(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val cityId: Int,
    val city: String,
    val weatherImg: Int,
    val temp: Float,
    val date: Date
    )
