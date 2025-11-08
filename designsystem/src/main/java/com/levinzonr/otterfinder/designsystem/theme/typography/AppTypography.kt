package com.levinzonr.otterfinder.designsystem.theme.typography

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle

/**
 * Custom holder for the Text styles instead of the one used in Material Design
 * Here You can put the styles the app needs and the one specified in you projects Figma
 *
 * secondary constructor uses Material Theme typography  from [Typography]
 * to maintain some corelation with Material Specification
 */
data class AppTypography(
    val headline1: TextStyle,
    val headline2: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val button: TextStyle,
) {

    constructor(typography: Typography) : this(
        headline1 = typography.headlineLarge,
        headline2 = typography.headlineMedium,
        body1 = typography.bodyLarge,
        body2 = typography.bodyMedium,
        button = typography.labelLarge,
    )
}
