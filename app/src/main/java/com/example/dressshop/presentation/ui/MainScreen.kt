package com.example.dressshop.presentation.ui

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dressshop.presentation.screens.AddDressScreen
import com.example.dressshop.presentation.screens.DressDetailScreen
import com.example.dressshop.presentation.screens.ListDressesScreen


import com.example.dressshop.ui.theme.DressShopTheme

enum class DressScreen(val title: String) {
    ListDresses(title = "Dresses"),
    SelectedDress(title = "Selected dress"),
    AddDress(title = "Add dress")
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation() {

                listOf(DressScreen.ListDresses, DressScreen.AddDress).forEach { screen ->
                    BottomNavigationItem(
                        selected = false,
                        onClick = {
                            navController.navigate(screen.name)
                        },
                        label = { Text(text = screen.title) },
                        icon = {}
                    )
                }
            }

        }) {
        NavHost(
            navController = navController,
            startDestination = DressScreen.ListDresses.name
        ) {

            composable(
                route = DressScreen.ListDresses.name
            ) {
                ListDressesScreen {
                    navController.navigate("${DressScreen.SelectedDress.name}/${it.id}")
                }
            }
            composable(
                route = "${DressScreen.SelectedDress.name}/{id}",
                arguments = listOf(
                    navArgument("id") { type = NavType.IntType }
                ),
            ) {
                DressDetailScreen()
            }

            composable(route = DressScreen.AddDress.name) {
                AddDressScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewMainScreen() {
    DressShopTheme {
        MainScreen()
    }
}