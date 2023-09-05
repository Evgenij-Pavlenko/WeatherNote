package com.example.abschlussaufgabe.adapter

import android.content.Context
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
import com.example.abschlussaufgabe.data.datamodels.WeatherWithNote
import com.example.abschlussaufgabe.ui.ArchiveFragmentDirections
import java.util.Date

class ArchiveAdapter (
    private val dataset: List<WeatherWithNote>
    ) : RecyclerView.Adapter<ArchiveAdapter.ItemViewHolder>() {

        class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
//            var weatherImg: TextView = view.findViewById(R.id.iv_archive)
            var tempValue: TextView = view.findViewById(R.id.tv_arhive)
            var tempData: TextView = view.findViewById(R.id.tv_data)
            val weatherWithNote: ConstraintLayout = view.findViewById(R.id.cl_archive)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val adapterLayout =
                LayoutInflater.from(parent.context).inflate(R.layout.archive_item, parent, false)
            return ItemViewHolder(adapterLayout)
        }

        override fun getItemCount(): Int {
            return dataset.size
        }

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            val item = dataset[position]

//            holder.weatherImg.setBackgroundResource(item.)
            holder.tempValue.text = item.temp.toString()
            holder.tempData.text = item.dt_txt.format("YY.MM.DD hh:mm")

            Log.e("Adapter", "LOG CITY0 ${item.city}")
            holder.weatherWithNote.setOnClickListener {
                Log.e("Adapter", "LOG CITY ${item.city}")
                holder.view.findNavController()
                    .navigate(ArchiveFragmentDirections.actionArhiveFragmentToDetailFragment(
                        item.temp,item.dt_txt,item.city, item.note))
                Log.e("Adapter", "LOG CITY2 ${item.city}")
            }
        }
}