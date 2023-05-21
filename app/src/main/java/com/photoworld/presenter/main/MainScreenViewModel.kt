package com.photoworld.presenter.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.photoworld.data.datastore.FiltersDataStore
import com.photoworld.data.model.ProfileType
import com.photoworld.presenter.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val filtersDataStore: FiltersDataStore,
) : ViewModel() {

    private val _searchState = mutableStateOf("")
    val searchState: State<String> = _searchState

    private val allUsers = listOf(
        SearchItemState(
            profileType = ProfileType.PHOTOGRAPHER,
            avatarUrl = "https://pw.artfile.me/wallpaper/15-05-2017/346x230/devushki--unsort--lica--portrety-vzglyad-1168658.jpg",
            name = "Кристина Сорокина",
            photoUrls = listOf(
                "https://pw.artfile.me/wallpaper/15-05-2017/346x230/devushki--unsort--lica--portrety-vzglyad-1168658.jpg",
                "https://is5-ssl.mzstatic.com/image/thumb/Music123/v4/8a/b6/3a/8ab63ae5-748f-2b7d-977a-753c722fd4d7/artwork.jpg/200x200bb.jpg",
                "https://wearethecity.com/wp-content/uploads/2018/12/Iconic-Women-Meet-Feature.jpg",
                "https://testchi.ir/frontend/images/tests/1630012531.jpg",
            )
        ),
        SearchItemState(
            profileType = ProfileType.PHOTOGRAPHER,
            avatarUrl = "https://sun9-47.userapi.com/impg/gO2AtlVrZUfcz3Z2xX8ZoDZ_Bnz89ppYVo-7Ww/d_WuSSIzQDI.jpg?size=722x738&quality=96&sign=82f7654ca808ab4102c3d11b8029853f&type=album",
            name = "Денис Озмаден",
            photoUrls = listOf(
                "https://sun9-47.userapi.com/impg/gO2AtlVrZUfcz3Z2xX8ZoDZ_Bnz89ppYVo-7Ww/d_WuSSIzQDI.jpg?size=722x738&quality=96&sign=82f7654ca808ab4102c3d11b8029853f&type=album",
                "https://is5-ssl.mzstatic.com/image/thumb/Music123/v4/8a/b6/3a/8ab63ae5-748f-2b7d-977a-753c722fd4d7/artwork.jpg/200x200bb.jpg",
                "https://wearethecity.com/wp-content/uploads/2018/12/Iconic-Women-Meet-Feature.jpg",
                "https://testchi.ir/frontend/images/tests/1630012531.jpg",
            )
        ),
        SearchItemState(
            profileType = ProfileType.MODEL,
            avatarUrl = "https://sun9-86.userapi.com/impf/c623229/v623229790/31bfc/NnOlp_fWz5E.jpg?size=320x213&quality=96&sign=b6ca9102098bdb24ff0eb2ddb752a76c&c_uniq_tag=TbWsYkOh1pZ6rkItkzUL9rGsOAL8vdRz-2_OuryLlV4&type=album",
            name = "Ада Паскаль",
            photoUrls = listOf(
                "https://sun9-86.userapi.com/impf/c623229/v623229790/31bfc/NnOlp_fWz5E.jpg?size=320x213&quality=96&sign=b6ca9102098bdb24ff0eb2ddb752a76c&c_uniq_tag=TbWsYkOh1pZ6rkItkzUL9rGsOAL8vdRz-2_OuryLlV4&type=album",
                "https://is5-ssl.mzstatic.com/image/thumb/Music123/v4/8a/b6/3a/8ab63ae5-748f-2b7d-977a-753c722fd4d7/artwork.jpg/200x200bb.jpg",
                "https://wearethecity.com/wp-content/uploads/2018/12/Iconic-Women-Meet-Feature.jpg",
                "https://testchi.ir/frontend/images/tests/1630012531.jpg",
            )
        ),
        SearchItemState(
            profileType = ProfileType.MODEL,
            avatarUrl = "https://pw.artfile.me/wallpaper/15-05-2017/346x230/devushki--unsort--lica--portrety-vzglyad-1168658.jpg",
            name = "Кристина Сорокина",
            photoUrls = listOf(
                "https://pw.artfile.me/wallpaper/15-05-2017/346x230/devushki--unsort--lica--portrety-vzglyad-1168658.jpg",
                "https://is5-ssl.mzstatic.com/image/thumb/Music123/v4/8a/b6/3a/8ab63ae5-748f-2b7d-977a-753c722fd4d7/artwork.jpg/200x200bb.jpg",
                "https://wearethecity.com/wp-content/uploads/2018/12/Iconic-Women-Meet-Feature.jpg",
                "https://testchi.ir/frontend/images/tests/1630012531.jpg",
            )
        ),
        SearchItemState(
            profileType = ProfileType.VISAGIST,
            avatarUrl = "https://sun9-47.userapi.com/impg/gO2AtlVrZUfcz3Z2xX8ZoDZ_Bnz89ppYVo-7Ww/d_WuSSIzQDI.jpg?size=722x738&quality=96&sign=82f7654ca808ab4102c3d11b8029853f&type=album",
            name = "Денис Озмаден",
            photoUrls = listOf(
                "https://sun9-47.userapi.com/impg/gO2AtlVrZUfcz3Z2xX8ZoDZ_Bnz89ppYVo-7Ww/d_WuSSIzQDI.jpg?size=722x738&quality=96&sign=82f7654ca808ab4102c3d11b8029853f&type=album",
                "https://is5-ssl.mzstatic.com/image/thumb/Music123/v4/8a/b6/3a/8ab63ae5-748f-2b7d-977a-753c722fd4d7/artwork.jpg/200x200bb.jpg",
                "https://wearethecity.com/wp-content/uploads/2018/12/Iconic-Women-Meet-Feature.jpg",
                "https://testchi.ir/frontend/images/tests/1630012531.jpg",
            )
        ),
        SearchItemState(
            profileType = ProfileType.VISAGIST,
            avatarUrl = "https://sun9-86.userapi.com/impf/c623229/v623229790/31bfc/NnOlp_fWz5E.jpg?size=320x213&quality=96&sign=b6ca9102098bdb24ff0eb2ddb752a76c&c_uniq_tag=TbWsYkOh1pZ6rkItkzUL9rGsOAL8vdRz-2_OuryLlV4&type=album",
            name = "Ада Паскаль",
            photoUrls = listOf(
                "https://sun9-86.userapi.com/impf/c623229/v623229790/31bfc/NnOlp_fWz5E.jpg?size=320x213&quality=96&sign=b6ca9102098bdb24ff0eb2ddb752a76c&c_uniq_tag=TbWsYkOh1pZ6rkItkzUL9rGsOAL8vdRz-2_OuryLlV4&type=album",
                "https://is5-ssl.mzstatic.com/image/thumb/Music123/v4/8a/b6/3a/8ab63ae5-748f-2b7d-977a-753c722fd4d7/artwork.jpg/200x200bb.jpg",
                "https://wearethecity.com/wp-content/uploads/2018/12/Iconic-Women-Meet-Feature.jpg",
                "https://testchi.ir/frontend/images/tests/1630012531.jpg",
            )
        ),
    )

    private val _searchResultState = searchUsers().toMutableStateList()
    val searchResultState: SnapshotStateList<SearchItemState> = _searchResultState

    fun onSearchChange(newValue: String) {
        _searchState.value = newValue
    }

    private fun searchUsers(): List<SearchItemState> {
        val filtersProfileType = filtersDataStore.getProfileType()
        return allUsers.filter { user ->
            (user.profileType == filtersProfileType || filtersProfileType == null)
                && user.name.startsWith(prefix = _searchState.value, ignoreCase = true)
        }
    }

    fun onSearch() {
        _searchResultState.clear()
        _searchResultState.addAll(searchUsers())
    }
}