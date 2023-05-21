package com.photoworld.presenter.photosessions.details.finish

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.photoworld.R
import com.photoworld.presenter.component.button.BaseButton
import com.photoworld.presenter.component.topbar.TopBar
import com.photoworld.presenter.main.UserItem
import com.photoworld.presenter.theme.Gray600

@Composable
fun FinishPhotoSessionScreen(
    navController: NavController,
    viewModel: FinishPhotoSessionViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(16.dp),
        topBar = {
            TopBar(
                title = stringResource(R.string.ending),
                onBack = { navController.navigateUp() },
                onCancel = { navController.navigateUp() },
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                LazyColumn(
                    modifier = Modifier.padding(bottom = 40.dp)
                ) {
                    items(viewModel.usersState) { user ->
                        UserItem(searchItemState = user)
                        Spacer(modifier = Modifier.height(20.dp))
                        BaseButton(
                            text = stringResource(R.string.add_feedback),
                            contentPadding = ButtonDefaults.ContentPadding,
                            backgroundColor = Gray600,
                            onClick = { viewModel.addFeedback(user) },
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        },
        bottomBar = {
            BaseButton(
                text = stringResource(R.string.end),
                onClick = viewModel::nextScreen,
            )
        }
    )
}