package com.photoworld.presenter.profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.photoworld.presenter.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
) : ViewModel() {

    private val _mainAvatarUrlState =
        mutableStateOf("https://besthqwallpapers.com/Uploads/18-7-2021/170488/thumb-chris-hemsworth-australian-actor-portrait-photoshoot-popular-actors.jpg")
    val mainAvatarUrlState: State<String> = _mainAvatarUrlState

    private val _nameState = mutableStateOf("Кузнецов Михаил")
    val nameState: State<String> = _nameState

    private val _subScreensState =
        mutableStateOf(ProfileSubScreensState(isPhotoSubScreenSelected = true))
    val subScreensState: State<ProfileSubScreensState> = _subScreensState

    private var _photoState = mutableStateListOf(
        "https://besthqwallpapers.com/Uploads/18-7-2021/170488/thumb-chris-hemsworth-australian-actor-portrait-photoshoot-popular-actors.jpg",
        "https://is5-ssl.mzstatic.com/image/thumb/Music123/v4/8a/b6/3a/8ab63ae5-748f-2b7d-977a-753c722fd4d7/artwork.jpg/200x200bb.jpg",
        "https://wearethecity.com/wp-content/uploads/2018/12/Iconic-Women-Meet-Feature.jpg",
    )
    val photoState: SnapshotStateList<String> = _photoState

    private val _aboutYourselfState = mutableStateOf("Начинающий фотограф")
    val aboutYourselfState: State<String> = _aboutYourselfState

    private val _experienceState = mutableStateOf("0 лет")
    val experienceState: State<String> = _experienceState

    private var _tagState = mutableStateListOf(
        "Обучение",
        "Студийная съемка",
        "Ню фотография",
        "Семейная съемка",
        "Выездная фотосъемка",
    )
    val tagState: SnapshotStateList<String> = _tagState

    fun onPhotosSelected() {
        _subScreensState.value = ProfileSubScreensState(isPhotoSubScreenSelected = true)
    }

    fun onInfoSelected() {
        _subScreensState.value = ProfileSubScreensState(isInfoSubScreenSelected = true)
    }

}