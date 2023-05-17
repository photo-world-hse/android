package com.photoworld.presenter.createprofile.tag

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.photoworld.domain.mapper.profile.ProfileTypeMapper
import com.photoworld.domain.usecase.profile.AddCreateProfileTagsUseCase
import com.photoworld.domain.usecase.profile.GetTagsUseCase
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateProfileTagViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val navigationManager: NavigationManager,
    private val profileTypeMapper: ProfileTypeMapper,
    private val getTagsUseCase: GetTagsUseCase,
    private val addCreateProfileTagsUseCase: AddCreateProfileTagsUseCase,
) : ViewModel() {

    private val _isLoadingState = mutableStateOf( true)
    val isLoadingState: State<Boolean> = _isLoadingState

    private val profileType = profileTypeMapper.map(
        profileTypeString = savedStateHandle[Screen.CreateProfileTag.PROFILE_TYPE_ARGUMENT] ?: ""
    )

    private val _tagsState = mutableStateListOf<CreateProfileTagState>()
    val tagsState: SnapshotStateList<CreateProfileTagState> = _tagsState

    init {
        viewModelScope.launch {
            try {
                val tagTexts = getTagsUseCase(profileType)
                val tags = tagTexts.map { tagText -> CreateProfileTagState(tagText) }
                _tagsState.addAll(tags)
                _isLoadingState.value = false
            } catch (error: Throwable) {
                println(error)
            }
        }
    }

    fun cancel() {
        navigationManager.newRoot(Screen.BottomNavigationScreen.Main.route)
    }

    fun nextScreen() {
        val tags = _tagsState.toList()
            .filter { createProfileTagState -> createProfileTagState.isSelected }
            .map { createProfileTagState -> createProfileTagState.text }
        addCreateProfileTagsUseCase.invoke(tags)
        navigationManager.navigate(Screen.CreateProfileAbout(profileType.value).route)
    }

    fun onCheckChange(index: Int) {
        _tagsState[index] = _tagsState[index].copy(isSelected = !_tagsState[index].isSelected)
    }

}