package com.example.dressshop.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dressshop.presentation.vm.AddDressScreenUIState
import com.example.dressshop.presentation.vm.AddDressScreenViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AddDressScreen(
    vm: AddDressScreenViewModel = hiltViewModel(),
    clickDress: () -> Unit
) {
    val addDressUIState: AddDressScreenUIState by vm.addDressScreenUIState.collectAsState()
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = addDressUIState.manufacturer,
            onValueChange = vm::updateDressStateManufacturer,
            label = {
                Text("Manufacturer")
            })
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = addDressUIState.model,
            onValueChange = vm::updateDressStateModel,
            label = {
                Text("Model")
            })
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = addDressUIState.sex,
            onValueChange = vm::updateDressStateSex,
            label = {
                Text("Sex")
            })
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = addDressUIState.fabric,
            onValueChange = vm::updateDressStateFabric,
            label = {
                Text("Fabric")
            })
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = addDressUIState.city,
            onValueChange = vm::updateDressStateCity,
            label = {
                Text("City")
            })
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = addDressUIState.color,
            onValueChange = vm::updateDressStateColor,
            label = {
                Text("Color")
            })

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                vm.saveDress()
                vm.updateDressState()
                keyboardController?.hide()
                clickDress.invoke()
            }
        ) {
            Text(text = "Add")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddDressScreenPreview() {
    //AddDressScreen()
}