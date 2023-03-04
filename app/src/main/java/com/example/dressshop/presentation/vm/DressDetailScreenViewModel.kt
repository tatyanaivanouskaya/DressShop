package com.example.dressshop.presentation.vm

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dressshop.domain.model.Dress
import com.example.dressshop.domain.repository.DressRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

data class DressUIState(
    val dress: Dress = Dress()
)

@HiltViewModel
class DressDetailScreenViewModel @Inject constructor(
    dressRepository: DressRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var dressId: Int = checkNotNull(savedStateHandle["id"])

    val dressUIState: StateFlow<DressUIState> = dressRepository.getDressInfo(dressId).map{
        DressUIState(it.toDress() )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = DressUIState()
    )
}