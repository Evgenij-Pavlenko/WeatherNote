package com.example.abschlussaufgabe.adapter

import android.content.Context
import android.icu.text.RelativeDateTimeFormatter.Direction
import android.text.Layout.Directions
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

class WeatherAdapter(
    private val dataset: List<Weather>
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

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.binding.tvData.text = item.dt_txt
        holder.binding.tvTempValue.text = item.main.temp.toString() + " C"
        holder.binding.clItem.setOnClickListener{
            holder.itemView.findNavController()
                .navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(item.id))
        }


//        holder.weather.setOnClickListener {
//            holder.view.findNavController()
//                .navigate(Direction.actionMainFragmentToEditFragment(item.id))
//        }
    }
}