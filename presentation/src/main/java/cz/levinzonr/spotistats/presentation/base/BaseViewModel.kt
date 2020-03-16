package cz.levinzonr.spotistats.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cz.levinzonr.roxie.*
import cz.levinzonr.spotistats.presentation.navigation.Route
import cz.levinzonr.spotistats.presentation.util.SingleEvent

abstract class BaseViewModel<A: BaseAction,C: BaseChange,S: BaseState> : RoxieViewModel<A, S, C>() {

    private val _navigationLiveData: MutableLiveData<SingleEvent<Route>> = MutableLiveData()

    val navigationLiveData: LiveData<SingleEvent<Route>>
        get() = _navigationLiveData

    fun navigateTo(route: Route) {
        _navigationLiveData.postValue(SingleEvent(route))
    }


}
