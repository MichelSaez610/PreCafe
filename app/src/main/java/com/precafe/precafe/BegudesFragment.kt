package com.precafe.precafe

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.precafe.precafe.databinding.FragmentBegudesBinding
import com.precafe.precafe.databinding.FragmentPrimerBinding

class BegudesFragment : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentBegudesBinding.inflate(inflater)


        val begudesNames = Provider.getBegudesNames()

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            begudesNames
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                sharedViewModel.setBeguda(Provider.Begudes[position])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

        binding.buttonNext.setOnClickListener{

            val selectedBeguda = binding.spinner.selectedItem.toString()
            val quantityBeguda = binding.editQuantitat.text.toString().toIntOrNull() ?: 0
            val preuBegudaString = binding.preuUnitari.text.toString().replace("€", "").trim()
            val preuBeguda = preuBegudaString.toDoubleOrNull() ?: 0.0

            sharedViewModel.setSelectedBeguda(selectedBeguda)
            sharedViewModel.setQuantityBeguda(quantityBeguda)
            sharedViewModel.setpreuBeguda(preuBeguda)

            findNavController().navigate(R.id.action_begudesFragment_to_totalFragment, null)
        }

        sharedViewModel.dataBeguda.observe(viewLifecycleOwner) { data ->
            binding.preuUnitari.text = data?.preu?.toString() + "€"
        }

        return binding.root
    }
}