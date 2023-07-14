package com.example.abschlussaufgabe.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.datamodels.Weather

class WeatherAdapter(
    private val dataset: List<Weather>
) : RecyclerView.Adapter<WeatherAdapter.ItemViewHolder>() {

    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val guestName: TextView = view.findViewById(R.id.item_name_text)
        val guestFood: TextView = view.findViewById(R.id.item_food_text)
        val guestRow: ConstraintLayout = view.findViewById(R.id.item_layout)
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

        holder.guestName.text = item.name
        holder.guestFood.text = item.food

        holder.guestRow.setOnClickListener {
            holder.view.findNavController()
                .navigate(MainFragmentDirections.actionMainFragmentToEditFragment(item.id))
        }
    }
}