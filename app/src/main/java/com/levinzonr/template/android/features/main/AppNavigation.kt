package com.levinzonr.template.android.features.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.levinzonr.template.android.features.otterfinder.OtterFinderDestination
import com.levinzonr.template.android.features.otterfinder.OtterFinderRoute

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = OtterFinderDestination,
    ) {
        composable<OtterFinderDestination> {
            OtterFinderRoute()
        }
    }
}
