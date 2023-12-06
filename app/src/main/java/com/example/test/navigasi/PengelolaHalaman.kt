package com.example.test.navigasi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.test.ui.theme.Halaman.DestinasiEntry
import com.example.test.ui.theme.Halaman.DestinasiHome
import com.example.test.ui.theme.Halaman.EntrySiswaScreen
import com.example.test.ui.theme.Halaman.HomeScreen

@Composable
fun SiswaApp(navController: NavHostController = rememberNavController()) {
    HostNavigasi(navController = navController)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(navController = navController, startDestination = DestinasiHome.route, modifier = Modifier)
    {
        composable(DestinasiHome.route){
            HomeScreen(
                navigateToItemEntry = {navController.navigate(DestinasiEntry.route)})
        }
        composable(DestinasiEntry.route){
            EntrySiswaScreen(navigetBack = {navController.popBackStack()})
        }
    }
}

