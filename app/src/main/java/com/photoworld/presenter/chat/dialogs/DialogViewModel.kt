package com.photoworld.presenter.chat.dialogs

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.photoworld.data.datastore.FiltersDataStore
import com.photoworld.data.model.ProfileType
import com.photoworld.presenter.main.SearchItemState
import com.photoworld.presenter.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DialogViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val filtersDataStore: FiltersDataStore,
) : ViewModel() {

    private val _messageState = mutableStateOf("")
    val messageState: State<String> = _messageState

    private val _usersState = mutableStateOf(
        filtersDataStore.getChatUser() ?: SearchItemState(
            profileType = ProfileType.MODEL,
            avatarUrl = "https://pw.artfile.me/wallpaper/15-05-2017/346x230/devushki--unsort--lica--portrety-vzglyad-1168658.jpg",
            name = "Кристина Сорокина",
            photoUrls = listOf()
        )
    )
    val usersState: State<SearchItemState> = _usersState

    private val _messagesState = mutableStateListOf<String>()
    val messagesState: SnapshotStateList<String> = _messagesState


    fun onMessageChange(value: String) {
        _messageState.value = value
    }

    fun send() {
        _messagesState.add(_messageState.value)
        _messageState.value = ""
    }

}