package com.photoworld.presenter.photosessions.details.finish.photo

import android.net.Uri
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FinishPhotosViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
) : ViewModel() {

    private var _imageState = mutableStateListOf<String>()
    val imageState: SnapshotStateList<String> = _imageState

    fun cancel() {
        navigationManager.newRoot(Screen.BottomNavigationScreen.PhotoSessions.route)
    }

    fun nextScreen() {
        navigationManager.navigate(Screen.FinishPhotoSession.route)
    }

    fun onNewImage(uri: Uri?) {
        uri?.let {
            _imageState.add(uri.toString())
        }
    }

}