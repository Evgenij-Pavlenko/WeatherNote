package com.example.abschlussaufgabe.data.local

import androidx.room.TypeConverter
import com.example.abschlussaufgabe.data.datamodels.MainInWeatherTemp
import com.example.abschlussaufgabe.data.datamodels.Weather
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.Date

class Converters {
    @TypeConverter
    fun fromDate(value: Date) = Json.encodeToString(value)

    @TypeConverter
    fun toDate(value: String) = Json.decodeFromString<Date>(value)

    @TypeConverter
    fun fromMainTemp (value: MainInWeatherTemp) = Json.encodeToString(value)

    @TypeConverter
    fun toMainTemp(value: String) = Json.decodeFromString<MainInWeatherTemp>(value)

    @TypeConverter
    fun fromWeather(value: Weather) = Json.encodeToString(value)

    @TypeConverter
    fun toWeather(value: String) = Json.decodeFromString<Weather>(value)
}