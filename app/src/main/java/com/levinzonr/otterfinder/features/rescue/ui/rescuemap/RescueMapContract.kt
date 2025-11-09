package com.levinzonr.otterfinder.features.rescue.ui.rescuemap

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.levinzonr.otterfinder.core.location.Location
import com.levinzonr.otterfinder.features.rescue.domain.models.Rescue
import kotlinx.serialization.Serializable


/**
 * Object used for a type safe destination to a RescueMap route
 */
@Serializable
object RescueMapDestination

/**
 * UI State that represents RescueMapScreen
 **/
data class RescueMapState(
    val rescues: List<Rescue> = emptyList()
)

/**
 * RescueMap Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/

sealed interface RescueMapAction {
    data object OnClick : RescueMapAction
}

