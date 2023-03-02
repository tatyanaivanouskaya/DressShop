package com.example.dressshop.presentation.vm


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dressshop.data.remote.dto.DressDtoItem
import com.example.dressshop.domain.model.Dress
import com.example.dressshop.domain.repository.DressRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


data class DressUiState(
    val itemList: List<Dress> = listOf()
)

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val dressRepository: DressRepository
) : ViewModel() {

    val dressUiState: StateFlow<DressUiState> = dressRepository.getDressesFromDB().map {
        DressUiState(it.map { dressEntity -> dressEntity .toDress() })
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = DressUiState()
    )

    init {
        loadDressesList()
    }

    fun loadDressesList() {
        viewModelScope.launch {
            val result = dressRepository.getDressesList()
            if (result.isSuccessful) {
                Log.d("gg", "dm:: isSuccessful = ${result.isSuccessful}")
                val listDressDtoItem: List<DressDtoItem> = result.body() ?: emptyList()

                Log.d("gg", "dm:: isSuccessful = ${result.isSuccessful}")


                if (!listDressDtoItem.isNullOrEmpty()) {
                    val listDressEntity = listDressDtoItem.filterNotNull()
                    dressRepository.loadDressesIntoDB(listDressEntity.map { it.toDressEntity() })
                }
            } else{
                Log.d("gg", "dm:: code = ${result.code()}")
            }
        }
    }
}