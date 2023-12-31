package com.example.abschlussaufgabe.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewModelScope
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.adapter.ArchiveAdapter
import com.example.abschlussaufgabe.adapter.WeatherAdapter
import com.example.abschlussaufgabe.databinding.FragmentArchiveBinding
import com.example.abschlussaufgabe.helper.WeatherTouchHelper
import com.example.abschlussaufgabe.viewmodel.HomeViewModel


class ArchiveFragment : Fragment() {

    private lateinit var binding: FragmentArchiveBinding
    private val viewModel: HomeViewModel by activityViewModels()
    override fun onStart() {
        super.onStart()
        viewModel.loadWeatherWithNote()
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadWeatherWithNote()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_archive, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Date und Time with format (String without secunden)
        val adapter = viewModel.weatherListWithNote.value?.let { ArchiveAdapter(it, viewModel) }
        binding.rvArchive.adapter = adapter


        WeatherTouchHelper { position ->
            adapter?.removeWeather(position)
        }.attachToRecyclerView(binding.rvArchive)

        // to RecycledView - get Weather with Note List
        viewModel.weatherListWithNote.observe(viewLifecycleOwner) {
            binding.rvArchive.adapter = ArchiveAdapter(it, viewModel)
        }

    }
}