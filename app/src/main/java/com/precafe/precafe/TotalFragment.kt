package com.precafe.precafe

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.precafe.precafe.databinding.FragmentPrimerBinding
import com.precafe.precafe.databinding.FragmentTotalBinding


class TotalFragment : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentTotalBinding.inflate(inflater)

        binding.nomPrimerPlat.text = sharedViewModel.getSelectedPlat()
        binding.preuPrimerPlat.text = sharedViewModel.getpreuPlat().toString()
        binding.quantitatPrimerPlat.text = sharedViewModel.getQuantityPlat().toString()
        binding.totalPrimerPlat.text = sharedViewModel.totalPlat().toString() + "€"

        binding.nomBeguda.text = sharedViewModel.getSelectedBeguda()
        binding.preuBeguda.text = sharedViewModel.getpreuBeguda().toString()
        binding.quantitatBeguda.text = sharedViewModel.getQuantityBeguda().toString()
        binding.totalBeguda.text = sharedViewModel.totalBeguda().toString() + "€"

        binding.totalFinal.text = sharedViewModel.totalFinal().toString() + "€"

        return binding.root
    }
}