package com.levinzonr.template.android.features.otterfinder

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class OtterFinderViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _stateFlow: MutableStateFlow<OtterFinderState> =
        MutableStateFlow(OtterFinderState())

    val stateFlow: StateFlow<OtterFinderState> = _stateFlow.asStateFlow()


}