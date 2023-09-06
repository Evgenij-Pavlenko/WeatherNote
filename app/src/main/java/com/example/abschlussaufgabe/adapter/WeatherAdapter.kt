package com.example.abschlussaufgabe.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.icu.text.RelativeDateTimeFormatter.Direction
import android.text.Layout.Directions
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.datamodels.Weather
import com.example.abschlussaufgabe.databinding.ListWeatherBinding
import com.example.abschlussaufgabe.ui.DetailFragmentDirections
import com.example.abschlussaufgabe.ui.HomeFragmentDirections
import java.text.DateFormat
import java.text.SimpleDateFormat

class WeatherAdapter(
    private val dataset: List<Weather>,
    val cityName: String
) : RecyclerView.Adapter<WeatherAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: ListWeatherBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            ListWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        // Date und Time with formatierung (String without secunden)
        var dateTime = item.dt_txt.substring(0, item.dt_txt.length - 3).replace('-', '.')

        holder.binding.tvData.text = dateTime
        holder.binding.tvTempValue.text = item.main.temp.toString() + " °C"
        holder.binding.clItem.setOnClickListener {

            // Navigate from Home Fragment to Detail Fragment
            holder.itemView.findNavController()
                .navigate(
                    HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                        item.main.temp,
                        item.dt_txt,
                        cityName,
                        ""
                    )
                )
        }
    }
}