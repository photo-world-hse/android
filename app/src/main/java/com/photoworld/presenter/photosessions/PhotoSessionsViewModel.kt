package com.photoworld.presenter.photosessions

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.photoworld.presenter.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotoSessionsViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
) : ViewModel() {

    private val _searchState = mutableStateOf("")
    val searchState: State<String> = _searchState

    private val _subScreensState =
        mutableStateOf(PhotoSessionsSubScreensState(isAllSubScreenSelected = true))
    val subScreensState: State<PhotoSessionsSubScreensState> = _subScreensState

    fun onSearchChange(newValue: String) {
        _searchState.value = newValue
    }

    fun onAllSubScreenSelected() {
        _subScreensState.value = PhotoSessionsSubScreensState(isAllSubScreenSelected = true)
    }

    fun onCurrentSubScreenSelected() {
        _subScreensState.value = PhotoSessionsSubScreensState(isCurrentSubScreenSelected = true)
    }

    fun onEndedSubScreenSelected() {
        _subScreensState.value = PhotoSessionsSubScreensState(isEndedSubScreenSelected = true)
    }

    fun onNewSubScreenSelected() {
        _subScreensState.value = PhotoSessionsSubScreensState(isNewSubScreenSelected = true)
    }

}