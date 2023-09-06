package com.example.abschlussaufgabe.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.Repository
import com.example.abschlussaufgabe.data.datamodels.WeatherWithNote
import com.example.abschlussaufgabe.data.local.getDatabaseWithNote
import com.example.abschlussaufgabe.data.remote.ApiService
import com.example.abschlussaufgabe.ui.ArchiveFragmentDirections
import com.example.abschlussaufgabe.viewmodel.HomeViewModel

class ArchiveAdapter (
    private val dataset: List<WeatherWithNote>,
    private val viewModel: HomeViewModel

) : RecyclerView.Adapter<ArchiveAdapter.ItemViewHolder>() {
//    private val database = getDatabaseWithNote(application)
//    private val repository = Repository(database, ApiService)
//    private val dataset: List<WeatherWithNote> = repository.getWeatherWithNote()
//    private val dataset: List<WeatherWithNote> = listOf()


        class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
//            var weatherImg: TextView = view.findViewById(R.id.iv_archive)
            var tempValue: TextView = view.findViewById(R.id.tv_temp_archive)
            var tempData: TextView = view.findViewById(R.id.tv_archive_date)
            var tempText: TextView = view.findViewById(R.id.tv_arhive_note)
            val weatherWithNote: ConstraintLayout = view.findViewById(R.id.cl_archive)
        }

    fun removeWeather(position: Int){
        viewModel.deleteWeatherWithNote(dataset[position])
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
            holder.tempText.text = item.note
            holder.tempData.text = item.dt_txt.format("YY.MM.DD hh:mm")

            holder.weatherWithNote.setOnClickListener {
                holder.view.findNavController()
                    .navigate(ArchiveFragmentDirections.actionArhiveFragmentToDetailFragment(
                        item.temp,item.dt_txt,item.city, item.note))
            }
        }
}