package com.photoworld.presenter.photosessions

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.photoworld.R
import com.photoworld.presenter.component.bottomnavigation.BottomNavigation
import com.photoworld.presenter.component.button.BaseButton
import com.photoworld.presenter.component.item.SelectableItem
import com.photoworld.presenter.component.textfield.SearchTextField
import com.photoworld.presenter.navigation.Screen
import com.photoworld.presenter.theme.Blue500
import com.photoworld.presenter.theme.Gray600
import com.photoworld.presenter.theme.Gray700
import com.photoworld.presenter.theme.Gray900
import com.photoworld.presenter.theme.Green100
import com.photoworld.presenter.theme.Green800
import com.photoworld.presenter.theme.InterMedium12TextStyle
import com.photoworld.presenter.theme.InterMedium18TextStyle
import com.photoworld.presenter.theme.InterMedium24TextStyle
import com.photoworld.presenter.theme.InterNormal14TextStyle
import com.photoworld.presenter.theme.InterNormal16TextStyle
import com.photoworld.presenter.theme.White
import com.photoworld.presenter.theme.Yellow100
import com.photoworld.presenter.theme.Yellow800

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
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SelectableItem(
                        text = stringResource(id = R.string.list),
                        isSelected = viewModel.photoSessionsViewTypeState.value == PhotoSessionsViewType.LIST,
                        onSelect = viewModel::onListSelected,
                    )
                    SelectableItem(
                        text = stringResource(id = R.string.calendar),
                        isSelected = viewModel.photoSessionsViewTypeState.value == PhotoSessionsViewType.CALENDAR,
                        onSelect = viewModel::onCalendarSelected,
                    )
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
                if (viewModel.photoSessionsViewTypeState.value == PhotoSessionsViewType.LIST) {
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
                    Spacer(modifier = Modifier.height(24.dp))
                    LazyColumn {
                        itemsIndexed(viewModel.photoSessionsState) { index, photoSession ->
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Gray700)
                                    .clickable { viewModel.goToDetails() }
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    when (photoSession.type) {
                                        PhotoSessionType.REQUEST -> {
                                            Box(
                                                modifier = Modifier
                                                    .clip(RoundedCornerShape(6.dp))
                                                    .background(Yellow100)
                                            ) {
                                                Text(
                                                    text = stringResource(id = R.string.invitation),
                                                    style = InterMedium12TextStyle,
                                                    color = Yellow800,
                                                    modifier = Modifier.padding(
                                                        horizontal = 8.dp,
                                                        vertical = 4.dp
                                                    )
                                                )
                                            }
                                        }
                                        PhotoSessionType.IN_PROGRESS -> {
                                            Box(
                                                modifier = Modifier
                                                    .clip(RoundedCornerShape(6.dp))
                                                    .background(Green100)
                                            ) {
                                                Text(
                                                    text = stringResource(id = R.string.current),
                                                    style = InterMedium12TextStyle,
                                                    color = Green800,
                                                    modifier = Modifier.padding(
                                                        horizontal = 8.dp,
                                                        vertical = 4.dp
                                                    )
                                                )
                                            }
                                        }
                                        PhotoSessionType.FINISHED -> {
                                            Box(
                                                modifier = Modifier
                                                    .clip(RoundedCornerShape(6.dp))
                                                    .background(Gray600)
                                            ) {
                                                Text(
                                                    text = stringResource(id = R.string.finished),
                                                    style = InterMedium12TextStyle,
                                                    modifier = Modifier.padding(
                                                        horizontal = 8.dp,
                                                        vertical = 4.dp
                                                    )
                                                )
                                            }
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Text(
                                        text = photoSession.name,
                                        style = InterMedium18TextStyle,
                                    )
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Row {
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_map_pin),
                                            contentDescription = "map_pin",
                                        )
                                        Spacer(modifier = Modifier.width(16.dp))
                                        Text(
                                            text = photoSession.place,
                                            style = InterNormal16TextStyle,
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Row {
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_clock),
                                            contentDescription = "clock",
                                        )
                                        Spacer(modifier = Modifier.width(16.dp))
                                        Text(
                                            text = photoSession.time,
                                            style = InterNormal16TextStyle,
                                        )
                                    }
                                    when (photoSession.type) {
                                        PhotoSessionType.IN_PROGRESS -> {
                                            Spacer(modifier = Modifier.height(16.dp))
                                            BaseButton(
                                                text = stringResource(R.string.go_to_chat),
                                                contentPadding = ButtonDefaults.ContentPadding,
                                                backgroundColor = Gray600,
                                                onClick = {},
                                            )
                                        }
                                        PhotoSessionType.REQUEST -> {
                                            Spacer(modifier = Modifier.height(16.dp))
                                            Row(modifier = Modifier.fillMaxWidth()) {
                                                BaseButton(
                                                    text = stringResource(R.string.accept),
                                                    onClick = {},
                                                    modifier = Modifier.weight(0.5F),
                                                    contentPadding = ButtonDefaults.ContentPadding,
                                                    backgroundColor = Gray600,
                                                )
                                                Spacer(modifier = Modifier.width(8.dp))
                                                BaseButton(
                                                    text = stringResource(R.string.reject),
                                                    onClick = {},
                                                    modifier = Modifier.weight(0.5F),
                                                    contentPadding = ButtonDefaults.ContentPadding,
                                                    backgroundColor = Gray600,
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(24.dp))
                        }
                        item {
                            Spacer(modifier = Modifier.height(40.dp))
                        }
                    }
                } else {
                    LazyColumn {
                        itemsIndexed(viewModel.photoSessionsState) { index, photoSession ->
                            if (photoSession.type == PhotoSessionType.IN_PROGRESS) {
                                Row(modifier = Modifier.fillMaxWidth()) {
                                    if (photoSession.showDate) {
                                        Column(
                                            modifier = Modifier.weight(0.1F),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                        ) {
                                            Text(
                                                text = photoSession.dayNumber,
                                                style = InterMedium24TextStyle,
                                            )
                                            Text(
                                                text = photoSession.day,
                                                style = InterMedium12TextStyle,
                                            )
                                        }
                                        Spacer(modifier = Modifier.weight(0.05F))
                                    } else {
                                        Spacer(modifier = Modifier.weight(0.15F))
                                    }
                                    Box(
                                        modifier = Modifier
                                            .weight(0.85F)
                                            .clip(RoundedCornerShape(8.dp))
                                            .background(Gray700)
                                            .clickable { viewModel.goToDetails() }
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .padding(16.dp)
                                        ) {
                                            Text(
                                                text = photoSession.name,
                                                style = InterNormal16TextStyle,
                                            )
                                            Spacer(modifier = Modifier.height(8.dp))
                                            Text(
                                                text = photoSession.timeToTime,
                                                style = InterNormal14TextStyle,
                                            )
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.height(24.dp))
                            }
                        }
                    }
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