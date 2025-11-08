package com.levinzonr.otterfinder.features.rescue.ui.rescuelist

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import kotlinx.serialization.Serializable


/**
 * Object used for a type safe destination to a RescueList route
 */
@Serializable
object RescueListDestination

/**
 * UI State that represents RescueListScreen
 **/
class RescueListState

/**
 * RescueList Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/

sealed interface RescueListAction {
    data object OnClick : RescueListAction
}

