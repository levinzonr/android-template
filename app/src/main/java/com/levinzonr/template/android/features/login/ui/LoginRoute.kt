package com.levinzonr.template.android.features.login.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.levinzonr.template.android.designsystem.theme.AppTheme

@Composable
fun LoginRoute(coordinator: LoginCoordinator) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsStateWithLifecycle(LoginState())

    // UI Actions
    val actions = rememberLoginActions(coordinator)

    // UI Rendering
    AppTheme {
        LoginScreen(uiState, actions)
    }
}

@Composable
fun rememberLoginActions(coordinator: LoginCoordinator): LoginActions {
    return remember(coordinator) {
        LoginActions(
            onEmailChange = coordinator.viewModel::onEmailChange,
            onLoginClick = coordinator.viewModel::login,
            onPasswordChange = coordinator.viewModel::onPasswordChange,
        )
    }
}
