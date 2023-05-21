package com.photoworld.presenter.photosessions.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.photoworld.R
import com.photoworld.presenter.component.button.BaseButton
import com.photoworld.presenter.component.button.BaseTextButton
import com.photoworld.presenter.component.item.ImageItem
import com.photoworld.presenter.component.topbar.TopBar
import com.photoworld.presenter.main.UserItem
import com.photoworld.presenter.navigation.Screen
import com.photoworld.presenter.theme.Gray600
import com.photoworld.presenter.theme.Gray900
import com.photoworld.presenter.theme.InterMedium14TextStyle
import com.photoworld.presenter.theme.InterMedium18TextStyle
import com.photoworld.presenter.theme.InterNormal14TextStyle
import com.photoworld.presenter.theme.White

@Composable
fun PhotoSessionDetailsScreen(
    navController: NavController,
    viewModel: PhotoSessionDetailsViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(16.dp),
        topBar = {
            TopBar(
                title = viewModel.nameState.value,
                onBack = viewModel::cancel,
                onCancel = viewModel::cancel,
            )
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.description),
                        style = MaterialTheme.typography.subtitle1,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = viewModel.descriptionState.value,
                        style = InterNormal14TextStyle,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.place),
                        style = MaterialTheme.typography.subtitle1,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = viewModel.placeState.value,
                        style = InterNormal14TextStyle,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.date_and_time),
                        style = MaterialTheme.typography.subtitle1,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = viewModel.dateAndTimeState.value,
                        style = InterNormal14TextStyle,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.photo_session_duration),
                        style = MaterialTheme.typography.subtitle1,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = viewModel.durationState.value,
                        style = InterNormal14TextStyle,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.photos),
                        style = MaterialTheme.typography.subtitle1,
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    LazyRow {
                        items(viewModel.photoState) { photoUrl ->
                            ImageItem(
                                model = photoUrl,
                                size = 80.dp,
                                roundedCornerSize = 4.dp,
                                padding = 4.dp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.organizer),
                        style = MaterialTheme.typography.subtitle1,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        ImageItem(
                            model = viewModel.organizerState.value.avatarUrl,
                            size = 70.dp,
                            roundedCornerSize = 24.dp,
                        )
                        Spacer(modifier = Modifier.width(30.dp))
                        Column {
                            Text(
                                text = stringResource(id = R.string.photographer),
                                style = InterMedium14TextStyle,
                                modifier = Modifier
                                    .background(
                                        color = Gray600,
                                        shape = RoundedCornerShape(6.dp),
                                    )
                                    .padding(8.dp)
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = viewModel.organizerState.value.name,
                                style = InterMedium18TextStyle,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.participants),
                        style = MaterialTheme.typography.subtitle1,
                    )
                }
                items(viewModel.participantsState) { searchItem ->
                    Spacer(modifier = Modifier.height(8.dp))
                    UserItem(searchItemState = searchItem)
                    Spacer(modifier = Modifier.height(8.dp))
                }
                item {
                    BaseTextButton(
                        text = stringResource(id = R.string.add_participant),
                        onClick = viewModel::addParticipant
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                BaseButton(
                    text = stringResource(R.string.write),
                    onClick = {},
                    modifier = Modifier.weight(0.5F),
                )
                Spacer(modifier = Modifier.width(8.dp))
                BaseButton(
                    text = stringResource(R.string.end),
                    backgroundColor = White,
                    contentColor = Gray900,
                    onClick = { navController.navigate(Screen.FinishPhotos.route) },
                    modifier = Modifier.weight(0.5F),
                )
            }
        }
    )
}
