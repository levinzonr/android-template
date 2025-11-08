package com.levinzonr.otterfinder.features.rescue.ui.rescuelist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class RescueListCoordinator(
    val viewModel: RescueListViewModel
) {
    val screenStateFlow = viewModel.stateFlow
    fun handle(action: RescueListAction) {
        when (action) {
            RescueListAction.OnClick -> { /* Handle action */
            }
        }
    }


}

@Composable
fun rememberRescueListCoordinator(
    viewModel: RescueListViewModel = hiltViewModel()
): RescueListCoordinator {
    return remember(viewModel) {
        RescueListCoordinator(
            viewModel = viewModel
        )
    }
}