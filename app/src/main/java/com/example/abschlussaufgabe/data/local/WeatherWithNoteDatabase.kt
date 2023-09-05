package com.example.abschlussaufgabe.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.abschlussaufgabe.data.datamodels.Weather
import com.example.abschlussaufgabe.data.datamodels.WeatherWithNote

@Database(entities = [WeatherWithNote::class], version = 1)
@TypeConverters(Converters::class)
abstract class WeatherWithNoteDatabase : RoomDatabase() {
    abstract val weatherWithNoteDatabaseDao: WeatherWithNoteDatabaseDao

}
private lateinit var INSTANCE: WeatherWithNoteDatabase

fun getDatabaseWithNote(context: Context): WeatherWithNoteDatabase {
    synchronized(WeatherWithNoteDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                WeatherWithNoteDatabase::class.java,
                "weatherWithNote_database"
            ).allowMainThreadQueries().build()
        }
    }
    return INSTANCE
}