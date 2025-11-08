package com.levinzonr.otterfinder.features.rescue.ui.rescuelist

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

@Composable
fun RescueListScreen(
    state: RescueListState,
    onAction: (RescueListAction) -> Unit
) {
    // TODO UI Rendering
}

@Composable
@Preview(name = "RescueList")
private fun RescueListScreenPreview(
    @PreviewParameter(RescueListStatePreviewParameterProvider::class)
    state: RescueListState
) {
    RescueListScreen(
        state = state,
        onAction = {}
    )
}

/**
 * PreviewParameter Provider for RescueListScreen Preview
 * Add values to the sequence to see the preview in different states
 **/
class RescueListStatePreviewParameterProvider : PreviewParameterProvider<RescueListState> {
    override val values: Sequence<RescueListState>
        get() = sequenceOf(
            RescueListState(),
        )
}
