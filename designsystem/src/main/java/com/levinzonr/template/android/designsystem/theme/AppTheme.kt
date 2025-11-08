package com.levinzonr.template.android.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import com.levinzonr.template.android.designsystem.theme.dimensions.Dimensions
import com.levinzonr.template.android.designsystem.theme.dimensions.LocalDimensions
import com.levinzonr.template.android.designsystem.theme.dimensions.ProvideDimensions
import com.levinzonr.template.android.designsystem.theme.typography.AppTypography
import com.levinzonr.template.android.designsystem.theme.typography.LocalAppTypography
import com.levinzonr.template.android.designsystem.theme.typography.ProvideAppTypography
import com.levinzonr.template.android.designsystem.theme.typography.Typography

/**
 * Main theme provider
 * Use [Theme.*] to access colors, typography and etc
 */
@Composable
fun AppTheme(
    isDarkMode: Boolean = isSystemInDarkTheme(),
    isSmallDevice: Boolean = isSmallDevice(),
    content: @Composable () -> Unit,
) {
    val dimensions = if (isSmallDevice) Dimensions.Small else Dimensions.Default
    ProvideDimensions(dimensions = dimensions) {
        ProvideAppTypography {
            MaterialTheme(
                colorScheme = if (isDarkMode) DarkColorScheme else LightColorScheme,
                typography = Typography,
                shapes = Shapes,
                content = content,
            )
        }
    }
}

/**
 * Shortcut to obtain App Theme values instead of using [MaterialTheme]
 * - Provides custom AppTypography instead of Material one
 * - Provides access to dimensions, that can vary based on device size
 */
object Theme {
    val typography: AppTypography @Composable get() = LocalAppTypography.current
    val colors: ColorScheme @Composable get() = MaterialTheme.colorScheme
    val shapes: Shapes @Composable get() = MaterialTheme.shapes
    val dimensions: Dimensions @Composable get() = LocalDimensions.current
}

private val LightColorScheme = lightColorScheme(
    primary = Green,
    onPrimary = Black,
    background = LightGrey,
    onBackground = DarkGrey,
    surface = White,
    onSurface = Black,
    error = Red,
    onError = White,
)

private val DarkColorScheme = darkColorScheme(
    primary = Green,
    onPrimary = Black,
    background = DarkGrey,
    onBackground = White,
    surface = Black,
    onSurface = White,
    error = Red,
    onError = White,
)

@Composable
private fun isSmallDevice(): Boolean = LocalConfiguration.current.screenWidthDp <= 360
