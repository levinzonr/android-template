package com.levinzonr.template.android.features.login.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import com.levinzonr.template.android.features.resources.ui.ResourcesDestination
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class LoginCoordinator(
    val viewModel: LoginViewModel,
    val navController: NavController,
    val scope: CoroutineScope,
) {
    val screenStateFlow = viewModel.stateFlow

    init {
        viewModel.stateFlow
            .filter { it.isLoggedIn }
            .onEach {
                navController.navigate(ResourcesDestination) {
                    popUpTo(LoginDestination) {
                        inclusive = true
                    }
                }
            }
            .launchIn(scope)
    }
}

@Composable
fun rememberLoginCoordinator(
    viewModel: LoginViewModel,
    navController: NavController,
    scope: CoroutineScope = rememberCoroutineScope(),
): LoginCoordinator {
    return remember(viewModel, navController, scope) {
        LoginCoordinator(
            viewModel = viewModel,
            navController = navController,
            scope = scope,
        )
    }
}
