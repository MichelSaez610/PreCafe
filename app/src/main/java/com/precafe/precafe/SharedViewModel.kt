package com.precafe.precafe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class SharedViewModel : ViewModel() {

    private val _selectedPlat = MutableLiveData<String>()
    val selectedItem: LiveData<String> get() = _selectedPlat

    private val _quantityPlat = MutableLiveData<Int>()
    val quantityPlat: LiveData<Int> get() = _quantityPlat

    private val _preuPlat = MutableLiveData<Number>()
    val preuPlat: LiveData<Number> get() = _preuPlat


    private val _selectedBeguda = MutableLiveData<String>()
    val selectedBeguda: LiveData<String> get() = _selectedBeguda

    private val _quantityBeguda = MutableLiveData<Int>()
    val quantityBeguda: LiveData<Int> get() = _quantityBeguda

    private val _preuBeguda = MutableLiveData<Number>()
    val preuBeguda: LiveData<Number> get() = _preuBeguda


    private val _dataPlat = MutableLiveData<PrimerPlatsModel>()
    val dataPlat: LiveData<PrimerPlatsModel> get() = _dataPlat

    private val _dataBeguda = MutableLiveData<BegudesModel>()
    val dataBeguda: LiveData<BegudesModel> get() = _dataBeguda

    fun setPlat(plat: PrimerPlatsModel) {
        _dataPlat.value = plat
    }

    fun setBeguda(beguda: BegudesModel) {
        _dataBeguda.value = beguda
    }

    fun setSelectedPlat(item: String) {
        _selectedPlat.value = item
    }

    fun setQuantityPlat(quantity: Int) {
        _quantityPlat.value = quantity
    }

    fun setpreuPlat(quantity: Number) {
        _preuPlat.value = quantity
    }

    fun setSelectedBeguda(item: String) {
        _selectedBeguda.value = item
    }

    fun setQuantityBeguda(quantity: Int) {
        _quantityBeguda.value = quantity
    }

    fun setpreuBeguda(quantity: Number) {
        _preuBeguda.value = quantity
    }

    fun getPlat(): PrimerPlatsModel? {
        return _dataPlat.value
    }

    fun getBeguda(): BegudesModel? {
        return _dataBeguda.value
    }

    fun getSelectedPlat(): String? {
        return _selectedPlat.value
    }

    fun getQuantityPlat(): Int? {
        return _quantityPlat.value
    }

    fun getSelectedBeguda(): String? {
        return _selectedBeguda.value
    }

    fun getQuantityBeguda(): Int? {
        return _quantityBeguda.value
    }

    fun getpreuPlat(): Number? {
        return _preuPlat.value
    }

    fun getpreuBeguda(): Number? {
        return _preuBeguda.value
    }

    fun totalPlat(): Number {
        val preu = getpreuPlat().toString().toDouble()
        val quantitat = getQuantityPlat().toString().toInt()

        return preu * quantitat
    }

    fun totalBeguda(): Number {
        val preu = getpreuBeguda().toString().toDouble()
        val quantitat = getQuantityBeguda().toString().toInt()

        return preu * quantitat
    }

    fun totalFinal(): Number {
        val plat = totalPlat().toDouble()
        val beguda = totalBeguda().toDouble()

        return plat + beguda
    }





}