package com.example.dressshop.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.dressshop.domain.model.Dress
import com.example.dressshop.presentation.vm.DressDetailScreenViewModel
import com.example.dressshop.presentation.vm.DressUIState

@Composable
fun DressDetailScreen(
    vm: DressDetailScreenViewModel = hiltViewModel()
) {
    val dress: DressUIState by vm.dressUIState.collectAsState()

    DressScreen(dress = dress.dress)

}

@Composable
fun DressScreen(dress: Dress) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter(dress.url),
                contentDescription = dress.model
            )
        }

        Text(
            text = "${dress.manufacturer} ${dress.model}",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 20.dp), Color.Gray
        )

        Row() {
            Text(
                text = "Category",
                modifier = Modifier.weight(1F),
                color = Color.Gray
            )
            Text(
                text = "dress category",
                modifier = Modifier.weight(1F)
            )
        }
        Row() {
            Text(
                text = "Brand",
                modifier = Modifier.weight(1F),
                color = Color.Gray
            )
            Text(
                text = dress.manufacturer,
                modifier = Modifier.weight(1F)
            )
        }
        Row() {
            Text(
                text = "Seller",
                modifier = Modifier.weight(1F),
                color = Color.Gray
            )
            Text(
                text = dress.model,
                modifier = Modifier.weight(1F)
            )
        }
        Row() {
            Text(
                text = "Sex",
                modifier = Modifier.weight(1F),
                color = Color.Gray
            )
            Text(
                text = dress.sex,
                modifier = Modifier.weight(1F)
            )
        }
        Row() {
            Text(
                text = "Silhouette",
                modifier = Modifier.weight(1F),
                color = Color.Gray
            )
            Text(
                text = dress.silhouette,
                modifier = Modifier.weight(1F)
            )
        }
        Row() {
            Text(
                text = "Fabric",
                modifier = Modifier.weight(1F),
                color = Color.Gray
            )
            Text(
                text = dress.fabric,
                modifier = Modifier.weight(1F)
            )
        }
        Row() {
            Text(
                text = "Size",
                modifier = Modifier.weight(1F),
                color = Color.Gray
            )
            Text(
                text = dress.size,
                modifier = Modifier.weight(1F)
            )
        }
        Row() {
            Text(
                text = "Color",
                modifier = Modifier.weight(1F),
                color = Color.Gray
            )
            Text(
                text = dress.color,
                modifier = Modifier.weight(1F)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DressDetailScreenPreview() {
    DressDetailScreen()
}
