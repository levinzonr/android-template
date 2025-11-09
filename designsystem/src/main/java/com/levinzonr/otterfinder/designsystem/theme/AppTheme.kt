package com.levinzonr.otterfinder.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import com.levinzonr.otterfinder.designsystem.theme.dimensions.Dimensions
import com.levinzonr.otterfinder.designsystem.theme.dimensions.LocalDimensions
import com.levinzonr.otterfinder.designsystem.theme.dimensions.ProvideDimensions
import com.levinzonr.otterfinder.designsystem.theme.typography.AppTypography
import com.levinzonr.otterfinder.designsystem.theme.typography.LocalAppTypography
import com.levinzonr.otterfinder.designsystem.theme.typography.ProvideAppTypography
import com.levinzonr.otterfinder.designsystem.theme.typography.Typography

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
    primary = Primary,
    onPrimary = OnPrimary,
    primaryContainer = PrimaryLight,
    onPrimaryContainer = OnPrimary,
    secondary = Secondary,
    onSecondary = OnSecondary,
    secondaryContainer = PrimaryLight,
    onSecondaryContainer = OnPrimary,
    background = LightGrey,
    onBackground = OnPrimary,
    surface = White,
    onSurface = OnPrimary,
    surfaceVariant = PrimaryLight,
    onSurfaceVariant = OnPrimaryLight,
    error = Error,
    onError = OnError,
    errorContainer = Color(0xFFFFD6C4),
    onErrorContainer = Error,
)

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryDark,
    onPrimary = OnPrimary,
    primaryContainer = Primary,
    onPrimaryContainer = OnPrimary,
    secondary = SecondaryDark,
    onSecondary = OnSecondary,
    secondaryContainer = Secondary,
    onSecondaryContainer = OnSecondary,
    background = DarkGrey,
    onBackground = White,
    surface = Color(0xFF1F1F1F),
    onSurface = White,
    surfaceVariant = Color(0xFF3D3D3D),
    onSurfaceVariant = LightGrey,
    error = Error,
    onError = OnError,
    errorContainer = Color(0xFF8B3E1F),
    onErrorContainer = Color(0xFFFFD6C4),
)

@Composable
private fun isSmallDevice(): Boolean = LocalConfiguration.current.screenWidthDp <= 360
