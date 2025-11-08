package com.levinzonr.template.android.features.otterfinder

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember


import androidx.lifecycle.compose.collectAsStateWithLifecycle


@Composable
fun OtterFinderRoute(
    coordinator: OtterFinderCoordinator = rememberOtterFinderCoordinator()
) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsStateWithLifecycle(OtterFinderState())

    // UI Actions
    val actionsHandler: (OtterFinderAction) -> Unit = { action ->
        coordinator.handle(action)
    }

    // UI Rendering
    OtterFinderScreen(
        state = uiState,
        onAction = actionsHandler
    )
}


