package com.levinzonr.template.android.features.otterfinder

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class OtterFinderCoordinator(
    val viewModel: OtterFinderViewModel
) {
    val screenStateFlow = viewModel.stateFlow
    fun handle(action: OtterFinderAction) {
        when (action) {
            OtterFinderAction.OnClick -> { /* Handle action */
            }
        }
    }


}

@Composable
fun rememberOtterFinderCoordinator(
    viewModel: OtterFinderViewModel = hiltViewModel()
): OtterFinderCoordinator {
    return remember(viewModel) {
        OtterFinderCoordinator(
            viewModel = viewModel
        )
    }
}