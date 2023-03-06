package com.example.dressshop.presentation.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dressshop.data.remote.repository.DressRequestModel
import com.example.dressshop.domain.repository.DressRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AddDressScreenUIState(
    val manufacturer: String = "",
    val model: String = "",
    val sex: String = "",
    val fabric: String = "",
    val city: String = "",
    val color: String = ""
)

@HiltViewModel
class AddDressScreenViewModel @Inject constructor(
    val repository: DressRepository
) : ViewModel() {

    private val _addDressScreenUIState = MutableStateFlow(AddDressScreenUIState())
    val addDressScreenUIState: StateFlow<AddDressScreenUIState> =
        _addDressScreenUIState.asStateFlow()

    fun updateDressStateManufacturer(manufacturer: String) =
        _addDressScreenUIState.update { it.copy(manufacturer = manufacturer) }

    fun updateDressStateModel(model: String) =
        _addDressScreenUIState.update { it.copy(model = model) }

    fun updateDressStateSex(sex: String) =
        _addDressScreenUIState.update { it.copy(sex = sex) }

    fun updateDressStateFabric(fabric: String) =
        _addDressScreenUIState.update { it.copy(fabric = fabric) }

    fun updateDressStateCity(city: String) =
        _addDressScreenUIState.update { it.copy(city = city) }

    fun updateDressStateColor(color: String) =
        _addDressScreenUIState.update { it.copy(color = color) }

    fun updateDressState() =
        _addDressScreenUIState.update { it.copy(
            manufacturer = "",
            model = "",
            sex = "",
            fabric = "",
            city = "",
            color = ""
        ) }

    fun saveDress() {
        val dressForSave = addDressScreenUIState.value
        val dressRequestModel = DressRequestModel(
            manufacturer = dressForSave.manufacturer,
            model = dressForSave.model,
            sex = dressForSave.sex,
            fabric = dressForSave.fabric,
            city = dressForSave.city,
            color = dressForSave.color,
            url = "https://n.nordstrommedia.com/id/sr3/bb6a3d8e-a401-44fb-bbab-5185d44b9124.jpeg?h=365&w=240&dpr=2"
        )
        viewModelScope.launch {
            try {
                repository.saveDress(dressRequestModel = dressRequestModel)

            } catch (e: Exception) {
                Log.d("gg", "error message: ${e.message}")
            }
        }
    }
}