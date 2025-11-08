package com.levinzonr.template.android.features.main

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.levinzonr.template.android.features.login.ui.LoginDestination
import com.levinzonr.template.android.features.login.ui.LoginRoute
import com.levinzonr.template.android.features.login.ui.LoginViewModel
import com.levinzonr.template.android.features.login.ui.rememberLoginCoordinator
import com.levinzonr.template.android.features.resources.ui.ResourcesDestination
import com.levinzonr.template.android.features.resources.ui.ResourcesRoute
import com.levinzonr.template.android.features.resources.ui.ResourcesViewModel
import com.levinzonr.template.android.features.resources.ui.rememberResourcesCoordinator

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = LoginDestination,
    ) {
        composable<LoginDestination> {
            val viewModel: LoginViewModel = hiltViewModel()
            val coordinator = rememberLoginCoordinator(
                viewModel = viewModel,
                navController = navController,
            )
            LoginRoute(coordinator = coordinator)
        }

        composable<ResourcesDestination> {
            val viewModel: ResourcesViewModel = hiltViewModel()
            val coordinator = rememberResourcesCoordinator(viewModel = viewModel)
            ResourcesRoute(coordinator = coordinator)
        }
    }
}
