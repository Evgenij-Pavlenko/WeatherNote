package com.example.abschlussaufgabe.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.adapter.WeatherAdapter
import com.example.abschlussaufgabe.data.datamodels.Weather
import com.example.abschlussaufgabe.databinding.FragmentHomeBinding
import com.example.abschlussaufgabe.viewmodel.HomeViewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by activityViewModels()
    var cityName :String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.weather.observe(viewLifecycleOwner){
            binding.tvTempGross.text = it.main.temp.toString() + " °C"
            binding.tvCity.text = it.name
            cityName = it.name
        }

        viewModel.weatherList.observe(viewLifecycleOwner) {
            binding.rvView.adapter = WeatherAdapter(it, cityName)
        }


        binding.rvView.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailHomeFragment())
        }
    }

}