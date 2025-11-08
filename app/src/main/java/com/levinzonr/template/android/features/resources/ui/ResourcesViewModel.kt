package com.levinzonr.template.android.features.resources.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.levinzonr.template.android.core.error.toError
import com.levinzonr.template.android.features.resources.domain.usecase.GetResourcesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class ResourcesViewModel @Inject constructor(
    private val getResourcesUseCase: GetResourcesUseCase,
) : ViewModel() {

    private val _stateFlow: MutableStateFlow<ResourcesState> = MutableStateFlow(ResourcesState())

    val stateFlow: StateFlow<ResourcesState> = _stateFlow.asStateFlow()

    init {
        viewModelScope.launch {
            _stateFlow.update { it.copy(isLoading = true) }
            val result = getResourcesUseCase()
            _stateFlow.update { state ->
                state.copy(
                    isLoading = false,
                    resources = result.getOrDefault(emptyList()),
                    error = result.exceptionOrNull()?.toError(),
                )
            }
        }
    }
}
