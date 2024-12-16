package com.precafe.precafe

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.precafe.precafe.databinding.FragmentPrimerBinding

class PrimerFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentPrimerBinding.inflate(inflater)

        val platsNames = Provider.getPlatsNames()

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            platsNames
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                sharedViewModel.setPlat(Provider.Plats[position])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }


        binding.buttonNext.setOnClickListener{

            val selectedPlat = binding.spinner.selectedItem.toString()
            val quantityPlat = binding.editQuantitat.text.toString().toIntOrNull() ?: 0
            val preuPlatString = binding.preuUnitari.text.toString().replace("€", "").trim()
            val preuPlat = preuPlatString.toDoubleOrNull() ?: 0.0


            sharedViewModel.setSelectedPlat(selectedPlat)
            sharedViewModel.setQuantityPlat(quantityPlat)
            sharedViewModel.setpreuPlat(preuPlat)

            findNavController().navigate(R.id.action_primerFragment_to_begudesFragment, null)
        }


        sharedViewModel.dataPlat.observe(viewLifecycleOwner) { data ->
            binding.preuUnitari.text = data?.preu?.toString() + "€"
        }

       return binding.root
    }

}