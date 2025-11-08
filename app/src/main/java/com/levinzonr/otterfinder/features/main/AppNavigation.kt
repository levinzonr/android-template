package com.levinzonr.otterfinder.features.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.levinzonr.otterfinder.features.rescue.ui.rescuemap.RescueMapDestination
import com.levinzonr.otterfinder.features.rescue.ui.rescuemap.RescueMapRoute

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = RescueMapDestination,
    ) {
        composable<RescueMapDestination> {
            RescueMapRoute()
        }
    }
}
