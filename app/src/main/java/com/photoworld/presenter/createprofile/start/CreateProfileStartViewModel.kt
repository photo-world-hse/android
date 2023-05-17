package com.photoworld.presenter.createprofile.start

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.photoworld.R
import com.photoworld.data.model.ProfileType
import com.photoworld.domain.model.profile.ProfilesInfo
import com.photoworld.domain.usecase.profile.GetProfilesUseCase
import com.photoworld.domain.usecase.profile.SetupProfileUseCase
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateProfileStartViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val getProfilesUseCase: GetProfilesUseCase,
    private val setupProfileUseCase: SetupProfileUseCase,
) : ViewModel() {

    private val _isLoadingState = mutableStateOf( true)
    val isLoadingState: State<Boolean> = _isLoadingState

    private val _toastMessage = MutableSharedFlow<Int>()
    val toastMessage: SharedFlow<Int> = _toastMessage.asSharedFlow()

    private var profilesInfo: ProfilesInfo? = null

    init {
        viewModelScope.launch {
            try {
                profilesInfo = getProfilesUseCase()
                _isLoadingState.value = false
            } catch (error: Throwable) {
                println(error)
            }
        }
    }

    fun createProfile(profileType: ProfileType) {
        if (profilesInfo?.profiles?.containsKey(profileType) == false) {
            setupProfileUseCase(profileType)
            navigationManager.navigate(Screen.CreateProfileTag(profileType.value).route)
        } else {
            viewModelScope.launch {
                _toastMessage.emit(R.string.profile_already_exist)
            }
        }
    }

    fun skip() {
        navigationManager.newRoot(Screen.BottomNavigationScreen.Main.route)
    }

}