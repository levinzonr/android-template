package com.levinzonr.otterfinder.features.rescue.ui.rescuemap

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember


import androidx.lifecycle.compose.collectAsStateWithLifecycle


@Composable
fun RescueMapRoute(
    coordinator: RescueMapCoordinator = rememberRescueMapCoordinator()
) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsStateWithLifecycle(RescueMapState())

    // UI Actions
    val actionsHandler: (RescueMapAction) -> Unit = { action ->
        coordinator.handle(action)
    }

    // UI Rendering
    RescueMapScreen(
        state = uiState,
        onAction = actionsHandler
    )
}


