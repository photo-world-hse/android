package com.photoworld.presenter.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.photoworld.R
import com.photoworld.presenter.component.bottomnavigation.BottomNavigation
import com.photoworld.presenter.component.item.SelectableItem
import com.photoworld.presenter.navigation.Screen

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel = hiltViewModel(),
) {
    Scaffold(
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding.calculateTopPadding() + 16.dp)
            ) {
                AvatarBarItem(
                    navController = navController,
                    url = viewModel.mainAvatarUrlState.value,
                    name = viewModel.nameState.value,
                    isProfile = true,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row {
                    SelectableItem(
                        text = stringResource(id = R.string.photos),
                        isSelected = viewModel.subScreensState.value.isPhotoSubScreenSelected,
                        onSelect = viewModel::onPhotosSelected,
                    )
                    SelectableItem(
                        text = stringResource(id = R.string.info),
                        isSelected = viewModel.subScreensState.value.isInfoSubScreenSelected,
                        onSelect = viewModel::onInfoSelected,
                    )
                    SelectableItem(
                        text = stringResource(id = R.string.feedback),
                        isSelected = viewModel.subScreensState.value.isFeedbackSubScreenSelected,
                        onSelect = viewModel::onFeedbackSelected,
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                when {
                    viewModel.subScreensState.value.isPhotoSubScreenSelected -> {
                        ProfilePhotoSubScreen()
                    }
                    viewModel.subScreensState.value.isInfoSubScreenSelected -> {
                        ProfileInfoSubScreen()
                    }
                }
            }
        },
        bottomBar = {
            BottomNavigation(
                selectedScreen = Screen.BottomNavigationScreen.Profile,
                navController = navController,
            )
        },
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize()
    )
}