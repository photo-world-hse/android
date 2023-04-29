package com.photoworld.presenter.photosessions.create.info

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreatePhotoSessionInfoViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
) : ViewModel() {

    private val _nameState = mutableStateOf("")
    val nameState: State<String> = _nameState

    private val _descriptionState = mutableStateOf("")
    val descriptionState: State<String> = _descriptionState

    private val _placeState = mutableStateOf("")
    val placeState: State<String> = _placeState

    private val _dateState = mutableStateOf("")
    val dateState: State<String> = _dateState

    private val _timeState = mutableStateOf("")
    val timeState: State<String> = _timeState

    private val _durationState = mutableStateOf("")
    val durationState: State<String> = _durationState

    fun onNameChange(newValue: String) {
        _nameState.value = newValue
    }

    fun onDescriptionChange(newValue: String) {
        _descriptionState.value = newValue
    }

    fun onPlaceChange(newValue: String) {
        _placeState.value = newValue
    }

    fun onDateChange(newValue: String) {
        _dateState.value = newValue
    }

    fun onTimeChange(newValue: String) {
        _timeState.value = newValue
    }

    fun onDurationChange(newValue: String) {
        _durationState.value = newValue
    }

    fun cancel() {
        navigationManager.newRoot(Screen.BottomNavigationScreen.PhotoSessions.route)
    }

    fun nextScreen() {
        navigationManager.navigate(Screen.CreatePhotoSessionImage.route)
    }

}