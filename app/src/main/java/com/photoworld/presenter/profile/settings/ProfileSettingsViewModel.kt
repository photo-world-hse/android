package com.photoworld.presenter.profile.settings

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.photoworld.data.datastore.FiltersDataStore
import com.photoworld.data.repository.LoginRepository
import com.photoworld.domain.usecase.profile.GetProfilesUseCase
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import com.photoworld.presenter.profile.ProfileSubScreensState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileSettingsViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val getProfilesUseCase: GetProfilesUseCase,
    private val loginRepository: LoginRepository,
    private val filtersDataStore: FiltersDataStore,
) : ViewModel() {

    private val _mainAvatarUrlState =
        mutableStateOf("https://sun9-76.userapi.com/impg/tFiwmC0q7nRKjfEuke3fs7zU8SYLrpCGJMsoOQ/i2jcaPW13vM.jpg?size=798x832&quality=96&sign=d52aec7d7c942312407d985f399aca47&type=album")
    val mainAvatarUrlState: State<String> = _mainAvatarUrlState

    private val _nameState = mutableStateOf(filtersDataStore.getUserName())
    val nameState: State<String> = _nameState

    private val _subScreensState =
        mutableStateOf(ProfileSubScreensState(isPhotoSubScreenSelected = true))
    val subScreensState: State<ProfileSubScreensState> = _subScreensState

    private var _photoState = mutableStateListOf(
        "https://sun9-76.userapi.com/impg/tFiwmC0q7nRKjfEuke3fs7zU8SYLrpCGJMsoOQ/i2jcaPW13vM.jpg?size=798x832&quality=96&sign=d52aec7d7c942312407d985f399aca47&type=album",
        "https://is5-ssl.mzstatic.com/image/thumb/Music123/v4/8a/b6/3a/8ab63ae5-748f-2b7d-977a-753c722fd4d7/artwork.jpg/200x200bb.jpg",
        "https://wearethecity.com/wp-content/uploads/2018/12/Iconic-Women-Meet-Feature.jpg",
    )
    val photoState: SnapshotStateList<String> = _photoState

    private val _aboutYourselfState = mutableStateOf("Начинающий фотограф")
    val aboutYourselfState: State<String> = _aboutYourselfState

    private val _experienceState = mutableStateOf("0 лет")
    val experienceState: State<String> = _experienceState

    private var _tagState = mutableStateListOf(
        "Портретный фотограф",
        "ТФП",
    )
    val tagState: SnapshotStateList<String> = _tagState

    init {
        viewModelScope.launch {
            try {
                val profilesInfo = getProfilesUseCase()
                if (profilesInfo.profiles.isEmpty()) {
                    navigationManager.replace(Screen.CreateProfileStart.route)
                }
            } catch (error: Throwable) {
                println(error)
            }
        }
    }

    fun onPhotosSelected() {
        _subScreensState.value = ProfileSubScreensState(isPhotoSubScreenSelected = true)
    }

    fun onInfoSelected() {
        _subScreensState.value = ProfileSubScreensState(isInfoSubScreenSelected = true)
    }

    fun onFeedbackSelected() {
        _subScreensState.value = ProfileSubScreensState(isFeedbackSubScreenSelected = true)
    }

    fun logout() {
        loginRepository.deleteAuthData()
        navigationManager.newRoot(Screen.Login.route)
    }

}