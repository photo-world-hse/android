package com.photoworld.presenter.photosessions.details.finish.feedback

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.photoworld.data.datastore.FiltersDataStore
import com.photoworld.data.model.ProfileType
import com.photoworld.presenter.main.SearchItemState
import com.photoworld.presenter.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeedbackViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val filtersDataStore: FiltersDataStore,
) : ViewModel() {

    private val _aboutState = mutableStateOf("")
    val aboutState: State<String> = _aboutState

    private val _usersState = mutableStateOf(
        filtersDataStore.getFeedback() ?: SearchItemState(
            profileType = ProfileType.MODEL,
            avatarUrl = "https://pw.artfile.me/wallpaper/15-05-2017/346x230/devushki--unsort--lica--portrety-vzglyad-1168658.jpg",
            name = "Кристина Сорокина",
            photoUrls = listOf()
        )
    )
    val usersState: State<SearchItemState> = _usersState

    private val _starState = mutableStateOf(0)
    val starState: State<Int> = _starState

    fun onAboutChange(newValue: String) {
        _aboutState.value = newValue
    }

    fun rate(rating: Int) {
        _starState.value = rating
    }

}