package com.levinzonr.template.android.features.otterfinder

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import kotlinx.serialization.Serializable


/**
 * Object used for a type safe destination to a OtterFinder route
 */
@Serializable
object OtterFinderDestination

/**
 * UI State that represents OtterFinderScreen
 **/
class OtterFinderState

/**
 * OtterFinder Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/

sealed interface OtterFinderAction {
    data object OnClick : OtterFinderAction
}

