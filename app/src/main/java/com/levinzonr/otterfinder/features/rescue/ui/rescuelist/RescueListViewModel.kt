package com.levinzonr.otterfinder.features.rescue.ui.rescuelist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class RescueListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _stateFlow: MutableStateFlow<RescueListState> = MutableStateFlow(RescueListState())

    val stateFlow: StateFlow<RescueListState> = _stateFlow.asStateFlow()


}