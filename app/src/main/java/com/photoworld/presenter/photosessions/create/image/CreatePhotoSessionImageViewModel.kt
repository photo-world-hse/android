package com.photoworld.presenter.photosessions.create.image

import android.net.Uri
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.photoworld.data.datastore.FiltersDataStore
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import com.photoworld.presenter.photosessions.PhotoSessionState
import com.photoworld.presenter.photosessions.PhotoSessionType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreatePhotoSessionImageViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val filtersDataStore: FiltersDataStore,
) : ViewModel() {

    private var _imageState = mutableStateListOf<String>()
    val imageState: SnapshotStateList<String> = _imageState

    fun cancel() {
        navigationManager.newRoot(Screen.BottomNavigationScreen.PhotoSessions.route)
    }

    fun nextScreen() {
        filtersDataStore.setPhotoSessions(
            mutableListOf(
                PhotoSessionState(
                    name = "Тестовая фотосессия",
                    place = "Рыбинск, Радищева, 8",
                    time = "28/04/2023 в 12:00",
                    type = PhotoSessionType.IN_PROGRESS,
                    showDate = true,
                    timeToTime = "12:00 - 14:00",
                    day = "ПТ",
                    dayNumber = "28",
                )
            )
        )
        navigationManager.newRoot(Screen.PhotoSessionDetails.route)
    }

    fun onNewImage(uri: Uri?) {
        uri?.let {
            _imageState.add(uri.toString())
        }
    }

}