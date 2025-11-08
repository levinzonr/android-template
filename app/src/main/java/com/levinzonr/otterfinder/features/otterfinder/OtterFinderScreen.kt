package com.levinzonr.otterfinder.features.otterfinder

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

@Composable
fun OtterFinderScreen(
    state: OtterFinderState,
    onAction: (OtterFinderAction) -> Unit
) {
    // TODO UI Rendering
}

@Composable
@Preview(name = "OtterFinder")
private fun OtterFinderScreenPreview(
    @PreviewParameter(OtterFinderStatePreviewParameterProvider::class)
    state: OtterFinderState
) {
    OtterFinderScreen(
        state = state,
        onAction = {}
    )
}

/**
 * PreviewParameter Provider for OtterFinderScreen Preview
 * Add values to the sequence to see the preview in different states
 **/
class OtterFinderStatePreviewParameterProvider : PreviewParameterProvider<OtterFinderState> {
    override val values: Sequence<OtterFinderState>
        get() = sequenceOf(
            OtterFinderState(),
        )
}
