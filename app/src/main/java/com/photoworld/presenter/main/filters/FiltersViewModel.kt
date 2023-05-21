package com.photoworld.presenter.main.filters

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.photoworld.data.datastore.FiltersDataStore
import com.photoworld.data.model.ProfileType
import com.photoworld.domain.usecase.profile.GetTagsUseCase
import com.photoworld.presenter.createprofile.tag.CreateProfileTagState
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FiltersViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val getTagsUseCase: GetTagsUseCase,
    private val filtersDataStore: FiltersDataStore,
) : ViewModel() {

    private val _isLoadingState = mutableStateOf(true)
    val isLoadingState: State<Boolean> = _isLoadingState

    private val _tagsState = mutableStateMapOf<ProfileType, List<CreateProfileTagState>>()
    val tagsState: SnapshotStateMap<ProfileType, List<CreateProfileTagState>> = _tagsState

    private val _ratingState = mutableStateOf("")
    val ratingState: State<String> = _ratingState

    private val _experienceFromState = mutableStateOf("")
    val experienceFromState: State<String> = _experienceFromState

    private val _experienceToState = mutableStateOf("")
    val experienceToState: State<String> = _experienceToState

    private val _selectedTypeState = mutableStateOf<ProfileType?>(null)
    val selectedTypeState: State<ProfileType?> = _selectedTypeState

    init {
        viewModelScope.launch {
            try {
                val tagsMap = ProfileType.values().associateWith { profileType ->
                    val tagTexts = getTagsUseCase(profileType)
                    val tags = tagTexts.map { tagText -> CreateProfileTagState(tagText) }
                    tags
                }
                _tagsState.putAll(tagsMap)
                _isLoadingState.value = false
            } catch (error: Throwable) {
                println(error)
            }
        }
    }

    fun onCheckChange(index: Int) {
        _selectedTypeState.value?.let { profileType ->
            val tags = _tagsState[profileType]?.toMutableList() ?: mutableListOf()
            if (index < tags.size) {
                tags[index] = tags[index].copy(isSelected = !tags[index].isSelected)
            }
            _tagsState[profileType] = tags
        }
    }

    fun onExperienceFromChange(newValue: String) {
        _experienceFromState.value = newValue
    }

    fun onExperienceToChange(newValue: String) {
        _experienceToState.value = newValue
    }

    fun onRatingChange(newValue: String) {
        _ratingState.value = newValue
    }

    fun onSelectedTypeChange(profileType: ProfileType?) {
        _selectedTypeState.value = profileType
    }

    fun save() {
        filtersDataStore.setProfileType(_selectedTypeState.value)
        navigationManager.navigate(Screen.BottomNavigationScreen.Main.route)
    }

}