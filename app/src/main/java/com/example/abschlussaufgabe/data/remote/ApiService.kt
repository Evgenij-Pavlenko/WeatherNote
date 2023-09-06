package com.example.abschlussaufgabe.data.remote

import android.content.res.Resources
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.datamodels.Weather
import com.example.abschlussaufgabe.data.datamodels.WeatherResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


// 1 - https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
// 2 - https://api.openweathermap.org/data/2.5/forecast?q={city name}&appid={API key}

const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// Retrofit übernimmt die Kommunikation und übersetzt die Antwort
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface WeatherApiService {

    //
    @GET("weather?units=metric")
    suspend fun getCurentWeather(@Query("q") city: String, @Query("appid") key: String): Weather
    @GET("forecast?units=metric")
    suspend fun getWeather(@Query("q") city: String, @Query("appid") key: String): WeatherResponse
}

object ApiService {
    val retrofitService: WeatherApiService by lazy { retrofit.create(WeatherApiService::class.java) }
}