package com.levinzonr.otterfinder.features.rescue.ui.rescuelist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember


import androidx.lifecycle.compose.collectAsStateWithLifecycle


@Composable
fun RescueListRoute(
    coordinator: RescueListCoordinator = rememberRescueListCoordinator()
) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsStateWithLifecycle(RescueListState())

    // UI Actions
    val actionsHandler: (RescueListAction) -> Unit = { action ->
        coordinator.handle(action)
    }

    // UI Rendering
    RescueListScreen(
        state = uiState,
        onAction = actionsHandler
    )
}


