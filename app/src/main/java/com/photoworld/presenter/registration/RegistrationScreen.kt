package com.photoworld.presenter.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.photoworld.presenter.component.textfield.BaseTextField
import com.photoworld.presenter.component.textfield.EmailTextField
import com.photoworld.presenter.component.textfield.PasswordTextField
import com.photoworld.presenter.navigation.Screen
import com.photoworld.presenter.theme.Blue500
import com.photoworld.presenter.theme.Gray400
import com.photoworld.presenter.theme.InterMedium14TextStyle

@Composable
fun RegistrationScreen(
    navController: NavController,
    viewModel: RegistrationViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(16.dp)
    ) { padding ->
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Text(
                text = stringResource(R.string.registration_title),
                style = MaterialTheme.typography.h6,
            )
            Spacer(modifier = Modifier.height(20.dp))
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
            Spacer(modifier = Modifier.height(20.dp))
            PasswordTextField(
                value = viewModel.passwordState.value,
                onValueChange = viewModel::onPasswordChange,
            )
            Spacer(modifier = Modifier.height(20.dp))
            PasswordTextField(
                value = viewModel.repeatPasswordState.value,
                onValueChange = viewModel::onRepeatPasswordChange,
                hint = stringResource(id = R.string.repeat_password_hint),
                topLabel = stringResource(R.string.repeat_password),
            )
            Spacer(modifier = Modifier.height(20.dp))
            BaseButton(
                text = stringResource(R.string.create_account_button),
                onClick = viewModel::createAccount,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.have_account_question),
                    style = InterMedium14TextStyle,
                    color = Gray400
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = stringResource(id = R.string.login_button),
                    style = InterMedium14TextStyle,
                    color = Blue500,
                    modifier = Modifier
                        .clickable { navController.navigate(Screen.Login.route) }
                )
            }
        }
    }
}