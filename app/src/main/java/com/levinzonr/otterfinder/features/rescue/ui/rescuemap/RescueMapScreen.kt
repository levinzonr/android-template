package com.levinzonr.otterfinder.features.rescue.ui.rescuemap

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MarkerComposable
import com.google.maps.android.compose.clustering.Clustering
import com.google.maps.android.compose.rememberTileOverlayState
import com.google.maps.android.compose.rememberUpdatedMarkerState
import com.levinzonr.otterfinder.features.otters.ui.OtterAvatar
import com.levinzonr.otterfinder.features.rescue.domain.models.Location
import com.levinzonr.otterfinder.features.rescue.domain.models.Rescue

@Composable
fun RescueMapScreen(
    state: RescueMapState,
    onAction: (RescueMapAction) -> Unit
) {
    GoogleMap {

        Clustering(
            items = state.rescues.map { RescueClusterItem(it) },
            clusterItemContent = {
                OtterAvatar(
                    otter = it.rescue.postedBy,
                    modifier = Modifier.size(32.dp)
                )
            }
        )

    }
}

val Location.latLong: LatLng get() = LatLng(latitude, longitude)

class RescueClusterItem(val rescue: Rescue) : ClusterItem {
    override fun getPosition(): LatLng = rescue.location.latLong

    override fun getTitle(): String? = ""

    override fun getSnippet(): String? = ""

    override fun getZIndex(): Float? = 0f
}

@Composable
@Preview(name = "RescueMap")
private fun RescueMapScreenPreview(
    @PreviewParameter(RescueMapStatePreviewParameterProvider::class)
    state: RescueMapState
) {
    RescueMapScreen(
        state = state,
        onAction = {}
    )
}

/**
 * PreviewParameter Provider for RescueMapScreen Preview
 * Add values to the sequence to see the preview in different states
 **/
class RescueMapStatePreviewParameterProvider : PreviewParameterProvider<RescueMapState> {
    override val values: Sequence<RescueMapState>
        get() = sequenceOf(
            RescueMapState(),
        )
}
