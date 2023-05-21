package com.photoworld.presenter.photosessions.details.finish.feedback

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
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
import com.photoworld.presenter.component.button.BaseButton
import com.photoworld.presenter.component.textfield.BaseTextField
import com.photoworld.presenter.component.topbar.TopBar
import com.photoworld.presenter.main.UserItem

@Composable
fun FeedbackScreen(
    navController: NavController,
    viewModel: FeedbackViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(16.dp),
        topBar = {
            TopBar(
                title = stringResource(R.string.add_feedback),
                onBack = navController::navigateUp,
                onCancel = navController::navigateUp,
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                UserItem(searchItemState = viewModel.usersState.value)
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = stringResource(id = R.string.add_feedback_to_user),
                    style = MaterialTheme.typography.subtitle1,
                )
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    items(count = 5) { index ->
                        val starRes = if (index<viewModel.starState.value) {
                            R.drawable.ic_star
                        } else {
                            R.drawable.ic_black_star
                        }
                        Image(
                            painter = painterResource(id = starRes),
                            contentDescription = "star",
                            modifier = Modifier.clickable { viewModel.rate(index+1) }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                BaseTextField(
                    value = viewModel.aboutState.value,
                    hint = stringResource(id = R.string.comment),
                    topLabel = stringResource(id = R.string.tell_more),
                    onValueChange = viewModel::onAboutChange,
                    modifier = Modifier
                        .defaultMinSize(
                            minWidth = 0.dp,
                            minHeight = 135.dp,
                        )
                )
            }
        },
        bottomBar = {
            BaseButton(
                text = stringResource(R.string.send),
                onClick = navController::navigateUp,
            )
        }
    )
}