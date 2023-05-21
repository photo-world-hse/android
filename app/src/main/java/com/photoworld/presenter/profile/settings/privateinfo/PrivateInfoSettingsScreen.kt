package com.photoworld.presenter.profile.settings.privateinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import com.photoworld.presenter.component.button.BaseButton
import com.photoworld.presenter.component.textfield.BaseTextField
import com.photoworld.presenter.component.textfield.EmailTextField
import com.photoworld.presenter.component.topbar.TopBar

@Composable
fun PrivateInfoSettingsScreen(
    navController: NavController,
    viewModel: PrivateInfoSettingsViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(16.dp),
        topBar = {
            TopBar(
                title = stringResource(R.string.profile_settings),
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
                BaseTextField(
                    value = viewModel.nameState.value,
                    onValueChange = viewModel::onNameChange,
                    hint = stringResource(id = R.string.name_hint),
                    topLabel = stringResource(R.string.name),
                )
                Spacer(modifier = Modifier.height(20.dp))
                EmailTextField(
                    value = viewModel.emailState.value,
                    onValueChange = viewModel::onEmailChange,
                )
            }
        },
        bottomBar = {
            BaseButton(
                text = stringResource(R.string.save),
                onClick = viewModel::save,
            )
        }
    )
}