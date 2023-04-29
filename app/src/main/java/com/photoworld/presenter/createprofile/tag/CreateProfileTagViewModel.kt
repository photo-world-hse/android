package com.photoworld.presenter.createprofile.tag

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateProfileTagViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
) : ViewModel() {

    private val _tagsState = mutableStateListOf(
        CreateProfileTagState(text = "Обучение"),
        CreateProfileTagState(text = "Репортажная съемка"),
        CreateProfileTagState(text = "Студийная съемка"),
        CreateProfileTagState(text = "Ню фотография"),
        CreateProfileTagState(text = "Свадебная съемка"),
        CreateProfileTagState(text = "Семейная съемка"),
        CreateProfileTagState(text = "Репортажная съемка"),
        CreateProfileTagState(text = "Выездная фотосъемка"),
        CreateProfileTagState(text = "Цветокоррекция"),
    )
    val tagsState: SnapshotStateList<CreateProfileTagState> = _tagsState

    fun cancel() {
        navigationManager.newRoot(Screen.BottomNavigationScreen.Main.route)
    }

    fun nextScreen() {
        navigationManager.navigate(Screen.CreateProfileAbout.route)
    }

    fun onCheckChange(index: Int) {
        _tagsState[index] = _tagsState[index].copy(isSelected = !_tagsState[index].isSelected)
    }

}