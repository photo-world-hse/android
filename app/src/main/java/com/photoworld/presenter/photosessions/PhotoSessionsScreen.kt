package com.photoworld.presenter.photosessions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.photoworld.R
import com.photoworld.presenter.component.bottomnavigation.BottomNavigation
import com.photoworld.presenter.component.item.SelectableItem
import com.photoworld.presenter.component.textfield.SearchTextField
import com.photoworld.presenter.navigation.Screen
import com.photoworld.presenter.theme.Blue500
import com.photoworld.presenter.theme.Gray900
import com.photoworld.presenter.theme.InterMedium12TextStyle
import com.photoworld.presenter.theme.White

@Composable
fun PhotoSessionsScreen(
    navController: NavController,
    viewModel: PhotoSessionsViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding.calculateTopPadding() + 16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.my_photo_sessions),
                    style = MaterialTheme.typography.h6,
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        onClick = { navController.navigate(Screen.CreatePhotoSessionInfo.route) },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = White),
                        contentPadding = PaddingValues(8.dp),
                    ) {
                        Text(
                            text = stringResource(id = R.string.create_photo_session),
                            style = InterMedium12TextStyle,
                            color = Gray900,
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.ic_plus),
                            contentDescription = "plus",
                            tint = Blue500,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                SearchTextField(
                    value = viewModel.searchState.value,
                    onValueChange = viewModel::onSearchChange,
                    onSearchClick = {},
                    withFilters = false,
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    SelectableItem(
                        text = stringResource(id = R.string.all),
                        isSelected = viewModel.subScreensState.value.isAllSubScreenSelected,
                        onSelect = viewModel::onAllSubScreenSelected,
                    )
                    SelectableItem(
                        text = stringResource(id = R.string.current),
                        isSelected = viewModel.subScreensState.value.isCurrentSubScreenSelected,
                        onSelect = viewModel::onCurrentSubScreenSelected,
                    )
                    SelectableItem(
                        text = stringResource(id = R.string.ended),
                        isSelected = viewModel.subScreensState.value.isEndedSubScreenSelected,
                        onSelect = viewModel::onEndedSubScreenSelected,
                    )
                    SelectableItem(
                        text = stringResource(id = R.string.invitations),
                        isSelected = viewModel.subScreensState.value.isNewSubScreenSelected,
                        onSelect = viewModel::onNewSubScreenSelected,
                    )
                }
            }
        },
        bottomBar = {
            BottomNavigation(
                selectedScreen = Screen.BottomNavigationScreen.PhotoSessions,
                navController = navController,
            )
        },
    )
}