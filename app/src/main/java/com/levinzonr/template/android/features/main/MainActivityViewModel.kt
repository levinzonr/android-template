package com.levinzonr.template.android.features.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class MainActivityViewModel @Inject constructor() : ViewModel() {

    private val _stateFlow = MutableStateFlow(MainActivityState())
    val stateFlow = _stateFlow.asStateFlow()

    init {
        _stateFlow.update {
            it.copy(
                showSplash = false,
            )
        }
    }
}
