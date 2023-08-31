package com.example.abschlussaufgabe.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.adapter.ArchiveAdapter
import com.example.abschlussaufgabe.adapter.WeatherAdapter
import com.example.abschlussaufgabe.databinding.FragmentArchiveBinding
import com.example.abschlussaufgabe.viewmodel.HomeViewModel


class ArchiveFragment : Fragment() {

    private lateinit var binding: FragmentArchiveBinding
    private val viewModel: HomeViewModel by activityViewModels()

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

        viewModel.weatherList.observe(viewLifecycleOwner) {
            binding.rvArchive.adapter = ArchiveAdapter(it)
        }

    }
}