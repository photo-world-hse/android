package com.photoworld.presenter.createprofile.about

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
import com.photoworld.presenter.theme.InterMedium18TextStyle

@Composable
fun CreateProfileAboutScreen(
    navController: NavController,
    viewModel: CreateProfileAboutViewModel = hiltViewModel(),
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(MaterialTheme.colors.background)
        ) {
            TopBar(
                title = stringResource(R.string.create_profile_title),
                onBack = { navController.navigateUp() },
                onCancel = viewModel::cancel,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(id = R.string.about_yourself),
                style = InterMedium18TextStyle,
            )
            Spacer(modifier = Modifier.height(12.dp))
            BaseTextField(
                value = viewModel.aboutState.value,
                hint = stringResource(id = R.string.about_yourself_hint),
                onValueChange = viewModel::onAboutChange,
                modifier = Modifier
                    .defaultMinSize(
                        minWidth = 0.dp,
                        minHeight = 135.dp,
                    )
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = stringResource(id = R.string.experience),
                style = InterMedium18TextStyle,
            )
            Spacer(modifier = Modifier.height(12.dp))
            BaseTextField(
                value = viewModel.experienceState.value,
                hint = stringResource(id = R.string.experience_hint),
                onValueChange = viewModel::onExperienceChange,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            Spacer(modifier = Modifier.weight(1f))
            BaseButton(
                text = stringResource(R.string.continue_button),
                onClick = viewModel::nextScreen,
            )
        }
    }
}
