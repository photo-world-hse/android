package com.photoworld.presenter.photosessions

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.photoworld.data.datastore.FiltersDataStore
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotoSessionsViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val filtersDataStore: FiltersDataStore,
) : ViewModel() {

    private val _photoSessionsViewTypeState = mutableStateOf(PhotoSessionsViewType.LIST)
    val photoSessionsViewTypeState: State<PhotoSessionsViewType> = _photoSessionsViewTypeState

    private val _searchState = mutableStateOf("")
    val searchState: State<String> = _searchState

    private val _subScreensState =
        mutableStateOf(PhotoSessionsSubScreensState(isAllSubScreenSelected = true))
    val subScreensState: State<PhotoSessionsSubScreensState> = _subScreensState

    private val _photoSessionsState = filtersDataStore.getPhotoSessions().toMutableStateList()
    val photoSessionsState: SnapshotStateList<PhotoSessionState> = _photoSessionsState

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

    fun onListSelected() {
        _photoSessionsViewTypeState.value = PhotoSessionsViewType.LIST
    }

    fun onCalendarSelected() {
        _photoSessionsViewTypeState.value = PhotoSessionsViewType.CALENDAR
    }

    fun goToDetails() {
        navigationManager.navigate(Screen.PhotoSessionDetails.route)
    }

}