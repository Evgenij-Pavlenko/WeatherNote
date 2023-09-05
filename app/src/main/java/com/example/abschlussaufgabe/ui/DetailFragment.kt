package com.example.abschlussaufgabe.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.datamodels.Weather
import com.example.abschlussaufgabe.data.datamodels.WeatherWithNote
import com.example.abschlussaufgabe.data.local.getDatabase
import com.example.abschlussaufgabe.databinding.FragmentDetailBinding
import com.example.abschlussaufgabe.viewmodel.HomeViewModel
import java.util.Date

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val viewmodel: HomeViewModel by viewModels()
    lateinit var weather: Weather
    lateinit var weatherWithNote: WeatherWithNote
    var temp: Float = 0.0F
    var name: String = ""
    var dt_txt: String = ""
    var note: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            temp = it.getFloat("temp")
            name = it.getString("city").toString()
            dt_txt = it.getString("date").toString()
            note = it.getString("note").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        note = binding.editTextText.text.toString()
        binding.tvDetailCity.text = name
        binding.tvDetailData.text = dt_txt.format("YYYY.MM.DD")
        binding.tvDetailTemp.text = temp.toString()
        weatherWithNote = WeatherWithNote(1, temp, name, dt_txt, note)
        Log.e("Detail", "note: $note")


        binding.btnSave.setOnClickListener {
            viewmodel.insertWeather(weatherWithNote)
            Log.e("Detail1", "note: $note")

        }

        binding.btnHome.setOnClickListener {
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToHomeFragment())
        }

        binding.btnArchive.setOnClickListener {
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToArchiveFragment())
        }
    }

}