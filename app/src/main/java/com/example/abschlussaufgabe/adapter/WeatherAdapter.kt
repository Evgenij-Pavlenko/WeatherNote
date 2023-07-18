package com.example.abschlussaufgabe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.datamodels.Weather
import com.example.abschlussaufgabe.ui.HomeFragment

class WeatherAdapter(
    private val context: Context,
    private val dataset: List<Weather>
) : RecyclerView.Adapter<WeatherAdapter.ItemViewHolder>() {

    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var weatherImg: TextView = view.findViewById(R.id.iv_weather)
        var tempValue: TextView = view.findViewById(R.id.tv_temp_value)
        val weather: ConstraintLayout = view.findViewById(R.id.cl_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_weather, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
//TODO
        holder.weatherImg.set = item.weatherImg
        holder.tempValue.text = item.temp.toString()

        holder.weather.setOnClickListener {
            holder.view.findNavController()
                .navigate(HomeFragmentDirection.actionMainFragmentToEditFragment(item.id))
        }
    }
}