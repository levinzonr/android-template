package com.levinzonr.otterfinder.features.rescue.ui.rescuemap

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.levinzonr.otterfinder.core.location.Location
import com.levinzonr.otterfinder.features.rescue.domain.usecase.GetRescuesAtLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class RescueMapViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getRescuesAtLocationUseCase: GetRescuesAtLocationUseCase,
) : ViewModel() {

    private val _stateFlow: MutableStateFlow<RescueMapState> = MutableStateFlow(RescueMapState())

    val stateFlow: StateFlow<RescueMapState> = _stateFlow.asStateFlow()

    fun loadRescues(location: Location) {
        viewModelScope.launch {
            getRescuesAtLocationUseCase(location).onSuccess {
                _stateFlow.update { state ->
                    state.copy(rescues = it)
                }
            }
        }
    }
}
