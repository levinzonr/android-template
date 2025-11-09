package com.levinzonr.otterfinder.features.rescue.ui.rescuemap

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.rememberCameraPositionState
import com.levinzonr.otterfinder.core.extensions.onFirst
import com.levinzonr.otterfinder.core.location.LiveLocationState
import com.levinzonr.otterfinder.core.location.Location
import com.levinzonr.otterfinder.core.location.rememberLiveLocationState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class RescueMapCoordinator(
    val viewModel: RescueMapViewModel,
    val liveLocationState: LiveLocationState,
    val scope: CoroutineScope,
    val cameraState: CameraPositionState,
) {
    val screenStateFlow = viewModel.stateFlow

    init {
        viewModel.loadRescues(Location.Mock)

        snapshotFlow { liveLocationState.currentLocation }
            .filterNotNull()
            .onFirst { cameraState.move(CameraUpdateFactory.newLatLng(it.latLong)) }
            .launchIn(scope)

        snapshotFlow { cameraState.position.target }
            .onEach { viewModel.loadRescues(Location(it.latitude, it.longitude)) }
            .launchIn(scope)
    }
    fun handle(action: RescueMapAction) {
        when (action) {
            RescueMapAction.OnClick -> {
                /* Handle action */
            }
        }
    }
}

@Composable
fun rememberRescueMapCoordinator(
    viewModel: RescueMapViewModel = hiltViewModel(),
    liveLocationState: LiveLocationState = rememberLiveLocationState(),
    scope: CoroutineScope = rememberCoroutineScope(),
    cameraState: CameraPositionState = rememberCameraPositionState(),
): RescueMapCoordinator {
    return remember(viewModel, liveLocationState) {
        RescueMapCoordinator(
            viewModel = viewModel,
            liveLocationState = liveLocationState,
            scope = scope,
            cameraState = cameraState,
        )
    }
}
