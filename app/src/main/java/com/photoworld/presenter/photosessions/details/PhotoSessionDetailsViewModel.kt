package com.photoworld.presenter.photosessions.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.photoworld.data.datastore.FiltersDataStore
import com.photoworld.data.model.ProfileType
import com.photoworld.presenter.main.SearchItemState
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotoSessionDetailsViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val filtersDataStore: FiltersDataStore,
) : ViewModel() {

    private val _nameState = mutableStateOf("Тестовая фотосессия")
    val nameState: State<String> = _nameState

    private val _descriptionState = mutableStateOf("Тестовое описание")
    val descriptionState: State<String> = _descriptionState

    private val _placeState = mutableStateOf("Рыбинск, Радищева, 8")
    val placeState: State<String> = _placeState

    private val _dateAndTimeState = mutableStateOf("28/04/2023 в 12:00")
    val dateAndTimeState: State<String> = _dateAndTimeState

    private val _durationState = mutableStateOf("2 часа")
    val durationState: State<String> = _durationState

    private val _photoState = mutableStateListOf(
        "https://is5-ssl.mzstatic.com/image/thumb/Music123/v4/8a/b6/3a/8ab63ae5-748f-2b7d-977a-753c722fd4d7/artwork.jpg/200x200bb.jpg",
        "https://wearethecity.com/wp-content/uploads/2018/12/Iconic-Women-Meet-Feature.jpg",
        "https://testchi.ir/frontend/images/tests/1630012531.jpg",
    )
    val photoState: SnapshotStateList<String> = _photoState

    private val _organizerState = mutableStateOf(
        SearchItemState(
            profileType = ProfileType.PHOTOGRAPHER,
            avatarUrl = "https://sun9-76.userapi.com/impg/tFiwmC0q7nRKjfEuke3fs7zU8SYLrpCGJMsoOQ/i2jcaPW13vM.jpg?size=798x832&quality=96&sign=d52aec7d7c942312407d985f399aca47&type=album",
            name = "Кузнецов Михаил",
            photoUrls = listOf()
        )
    )
    val organizerState: State<SearchItemState> = _organizerState

    private val _participantsState = filtersDataStore.getUsers().toMutableStateList()
    val participantsState: SnapshotStateList<SearchItemState> = _participantsState

    fun cancel() {
        navigationManager.newRoot(Screen.BottomNavigationScreen.PhotoSessions.route)
    }

    fun addParticipant() {
        filtersDataStore.setAdd(true)
        navigationManager.navigate(Screen.BottomNavigationScreen.Main.route)
    }

}