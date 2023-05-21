package com.photoworld.presenter.profile.settings.privateinfo

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.photoworld.data.datastore.FiltersDataStore
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PrivateInfoSettingsViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val filtersDataStore: FiltersDataStore,
) : ViewModel() {

    private val _nameState = mutableStateOf("Кузнецов Михаил")
    val nameState: State<String> = _nameState

    private val _emailState = mutableStateOf("mishafk15@mail.ru")
    val emailState: State<String> = _emailState

    fun onNameChange(newValue: String) {
        _nameState.value = newValue
    }

    fun onEmailChange(newValue: String) {
        _emailState.value = newValue
    }

    fun save() {
        filtersDataStore.setUserName(_nameState.value)
        navigationManager.navigate(Screen.ProfileSettings.route)
    }
}