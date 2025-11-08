package com.levinzonr.otterfinder.designsystem.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.levinzonr.otterfinder.core.ui.extensions.bold
import com.levinzonr.otterfinder.designsystem.theme.AppTheme
import com.levinzonr.otterfinder.designsystem.theme.Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    modifier: Modifier = Modifier,
    onBackButtonClick: (() -> Unit)? = null,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = title,
                style = Theme.typography.headline2.bold,
            )
        },
        navigationIcon = {
            onBackButtonClick?.let { onBackClick ->
                IconButton(onClick = onBackClick) {
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Theme.colors.primary,
            titleContentColor = Theme.colors.onPrimary,
            navigationIconContentColor = Theme.colors.onPrimary,
        ),
    )
}

@Composable
@Preview(name = "App Top Bar - Default")
private fun PreviewAppTopBar() {
    AppTheme {
        AppTopBar(title = "Top Bar")
    }
}

@Composable
@Preview(name = "App Top Bar - Back Button Shown")
private fun PreviewAppTopBarWithBackButton() {
    AppTheme {
        AppTopBar(
            title = "Top Bar",
            onBackButtonClick = { },
        )
    }
}
