package com.example.dressshop.presentation.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.dressshop.domain.model.Dress
import com.example.dressshop.presentation.vm.ListDressesUiState
import com.example.dressshop.presentation.vm.ListDressesScreenViewModel

@Composable
fun ListDressesScreen(
    vm: ListDressesScreenViewModel = hiltViewModel(),
    clickMachine: (Dress) -> Unit
) {

    val list: ListDressesUiState by vm.listDressesUiState.collectAsState()

    LazyColumn() {
        items(list.itemList) { dress ->
            DressBox(dress) {
                Log.d("ListDressesScreen", "dm:: clicked dress Id = ${it.id}")
                clickMachine.invoke(it)
            }
        }
    }
}

@Composable
fun DressBox(
    dress: Dress,
    clickMachine: (Dress) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(200.dp)
            .clickable {
                clickMachine(dress)
            },

        ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.BottomStart
        ) {
            Image(
                painter = rememberAsyncImagePainter(dress.url),
                contentDescription = "dress picture",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop

            )
            Text(
                text = "${dress.manufacturer} ${dress.model}",
                modifier = Modifier
                    .height(50.dp)
                    .background(color = Color.Gray.copy(alpha = 0.6F))
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListDressesScreenPreview() {
    //ListDressesScreen()
}