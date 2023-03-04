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


data class ListDressesUiState(
    val itemList: List<Dress> = listOf()
)

@HiltViewModel
class ListDressesScreenViewModel @Inject constructor(
    private val dressRepository: DressRepository
) : ViewModel() {

    val listDressesUiState: StateFlow<ListDressesUiState> = dressRepository.getDressesFromDB().map {
        ListDressesUiState(it.map { dressEntity -> dressEntity .toDress() })
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = ListDressesUiState()
    )

    init {
        loadDressesList()
    }

    private fun loadDressesList() {
        viewModelScope.launch {
            val result = dressRepository.getDressesList()
            if (result.isSuccessful) {
                val listDressDtoItem: List<DressDtoItem> = result.body() ?: emptyList()

                if (listDressDtoItem.isNotEmpty()) {
                    dressRepository.loadDressesIntoDB(listDressDtoItem.map { it.toDressEntity() })
                }
            } else{
                Log.d("gg", "dm:: code = ${result.code()}")
            }
        }
    }
}