package com.levinzonr.otterfinder.features.rescue.ui.rescuemap

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.levinzonr.otterfinder.features.rescue.domain.models.Location

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class RescueMapCoordinator(
    val viewModel: RescueMapViewModel
) {
    val screenStateFlow = viewModel.stateFlow

    init {
        viewModel.loadRescues(Location.Mock)
    }
    fun handle(action: RescueMapAction) {
        when (action) {
            RescueMapAction.OnClick -> { /* Handle action */
            }
        }
    }


}

@Composable
fun rememberRescueMapCoordinator(
    viewModel: RescueMapViewModel = hiltViewModel()
): RescueMapCoordinator {
    return remember(viewModel) {
        RescueMapCoordinator(
            viewModel = viewModel
        )
    }
}