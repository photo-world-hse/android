package com.photoworld.presenter.createprofile.about

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
fun CreateProfileAboutScreen(
    navController: NavController,
    viewModel: CreateProfileAboutViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(16.dp),
        topBar = {
            TopBar(
                title = stringResource(R.string.create_profile_title),
                onBack = { navController.navigateUp() },
                onCancel = viewModel::cancel,
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                BaseTextField(
                    value = viewModel.aboutState.value,
                    hint = stringResource(id = R.string.about_yourself_hint),
                    topLabel = stringResource(id = R.string.about_yourself),
                    onValueChange = viewModel::onAboutChange,
                    modifier = Modifier
                        .defaultMinSize(
                            minWidth = 0.dp,
                            minHeight = 135.dp,
                        )
                )
                Spacer(modifier = Modifier.height(20.dp))
                BaseTextField(
                    value = viewModel.experienceState.value,
                    hint = stringResource(id = R.string.experience_hint),
                    topLabel = stringResource(id = R.string.experience),
                    onValueChange = viewModel::onExperienceChange,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )
            }
        },
        bottomBar = {
            BaseButton(
                text = stringResource(R.string.continue_button),
                onClick = viewModel::nextScreen,
            )
        }
    )
}
