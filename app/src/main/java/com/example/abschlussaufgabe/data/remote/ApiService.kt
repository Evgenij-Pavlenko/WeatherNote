package com.example.abschlussaufgabe.data.remote

import com.example.abschlussaufgabe.data.datamodels.Weather
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


// https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
const val API_KEY = "7833fe0081beeb67548335c7497c54a2"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// Retrofit übernimmt die Kommunikation und übersetzt die Antwort
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface WeatherApiService {
    @GET("weather")
    suspend fun getCharacters(@Query("q") city: String, @Query("appid") key: String): Weather
}

object ApiService {
    val retrofitService: WeatherApiService by lazy { retrofit.create(WeatherApiService::class.java) }
}