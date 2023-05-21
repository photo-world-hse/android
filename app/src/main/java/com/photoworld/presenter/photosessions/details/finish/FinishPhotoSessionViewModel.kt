package com.photoworld.presenter.photosessions.details.finish

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.photoworld.data.datastore.FiltersDataStore
import com.photoworld.presenter.main.SearchItemState
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FinishPhotoSessionViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val filtersDataStore: FiltersDataStore,
) : ViewModel() {

    private val _usersState = filtersDataStore.getUsers().toMutableStateList()
    val usersState: SnapshotStateList<SearchItemState> = _usersState

    fun addFeedback(feedback: SearchItemState) {
        filtersDataStore.setFeedback(feedback)
        navigationManager.navigate(Screen.Feedback.route)
    }

    fun nextScreen() {
        navigationManager.newRoot(Screen.BottomNavigationScreen.PhotoSessions.route)
    }

}