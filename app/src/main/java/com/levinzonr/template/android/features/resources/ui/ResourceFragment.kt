package com.levinzonr.template.android.features.resources.ui

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import com.levinzonr.template.android.core.ui.ComposeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResourceFragment : ComposeFragment() {

    private val viewModel by viewModels<ResourcesViewModel>()

    override val content: @Composable () -> Unit = {
        val coordinator = rememberResourcesCoordinator(viewModel = viewModel)
        ResourcesRoute(coordinator)
    }
}
