package com.levinzonr.otterfinder.features.otters.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.levinzonr.otterfinder.designsystem.theme.AppTheme
import com.levinzonr.otterfinder.designsystem.theme.Theme
import com.levinzonr.otterfinder.features.otters.domain.models.Otter

@Composable
fun OtterAvatar(
    otter: Otter,
    modifier: Modifier = Modifier
) {
    Surface(
        color = Theme.colors.primary,
        shape = CircleShape,
        modifier = modifier.aspectRatio(1f),
        border = BorderStroke(12.dp, Theme.colors.secondary)
    ) {

        Image(
            painter = painterResource(otter.imageResource),
            contentDescription = null,
            modifier = Modifier.clip(CircleShape).scale(0.8f),
        )
    }
}

@Preview
@Composable
private fun PreviewOtterAvatar() {
    AppTheme{
        OtterAvatar(Otter.Mock )
    }
}