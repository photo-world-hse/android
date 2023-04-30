package com.photoworld.presenter.photosessions.create.info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.photoworld.R
import com.photoworld.presenter.component.button.BaseButton
import com.photoworld.presenter.component.textfield.BaseTextField
import com.photoworld.presenter.component.topbar.TopBar

@Composable
fun CreatePhotoSessionInfoScreen(
    navController: NavController,
    viewModel: CreatePhotoSessionInfoViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(16.dp),
        topBar = {
            TopBar(
                title = stringResource(R.string.create_photo_session_top_bar),
                onBack = { navController.navigateUp() },
                onCancel = viewModel::cancel,
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(padding)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                BaseTextField(
                    value = viewModel.nameState.value,
                    hint = stringResource(id = R.string.photo_session_name),
                    topLabel = stringResource(id = R.string.photo_session_name_hint),
                    onValueChange = viewModel::onNameChange,
                )
                Spacer(modifier = Modifier.height(20.dp))
                BaseTextField(
                    value = viewModel.descriptionState.value,
                    hint = stringResource(id = R.string.photo_session_description_hint),
                    topLabel = stringResource(id = R.string.description),
                    onValueChange = viewModel::onDescriptionChange,
                    modifier = Modifier
                        .defaultMinSize(
                            minWidth = 0.dp,
                            minHeight = 135.dp,
                        )
                )
                Spacer(modifier = Modifier.height(20.dp))
                BaseTextField(
                    value = viewModel.placeState.value,
                    hint = stringResource(id = R.string.place_hint),
                    topLabel = stringResource(id = R.string.place),
                    onValueChange = viewModel::onPlaceChange,
                )
                Spacer(modifier = Modifier.height(20.dp))
                BaseTextField(
                    value = viewModel.dateState.value,
                    hint = stringResource(id = R.string.date_hint),
                    topLabel = stringResource(id = R.string.date),
                    onValueChange = viewModel::onDateChange,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                )
                Spacer(modifier = Modifier.height(20.dp))
                BaseTextField(
                    value = viewModel.timeState.value,
                    hint = stringResource(id = R.string.time_hint),
                    topLabel = stringResource(id = R.string.time),
                    onValueChange = viewModel::onTimeChange,
                )
                Spacer(modifier = Modifier.height(20.dp))
                BaseTextField(
                    value = viewModel.durationState.value,
                    hint = stringResource(id = R.string.photo_session_duration_hint),
                    topLabel = stringResource(id = R.string.photo_session_duration),
                    onValueChange = viewModel::onDurationChange,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                )
            }
        },
        bottomBar = {
            BaseButton(
                text = stringResource(R.string.continue_button),
                onClick = viewModel::nextScreen,
                modifier = Modifier
                    .padding(top = 16.dp)
            )
        }
    )
}
