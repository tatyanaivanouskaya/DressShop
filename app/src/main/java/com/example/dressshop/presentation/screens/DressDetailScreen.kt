package com.example.dressshop.presentation.screens

import android.util.Log
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@Composable
fun DressDetailScreen(
    vm: DressViewModel = hiltViewModel()
) {

    Text(text = "Some about dress")

}


@HiltViewModel
class DressViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val machineId: Int = checkNotNull(savedStateHandle["id"])

    init {
        Log.d("sdf", "dm:: dressId = $machineId ")
    }

}
