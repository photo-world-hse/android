package com.photoworld.presenter.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.photoworld.R
import com.photoworld.presenter.component.button.BaseButton
import com.photoworld.presenter.component.textfield.EmailTextField
import com.photoworld.presenter.component.textfield.PasswordTextField
import com.photoworld.presenter.navigation.Screen
import com.photoworld.presenter.theme.Blue500
import com.photoworld.presenter.theme.Gray400
import com.photoworld.presenter.theme.InterMedium14TextStyle

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel(),
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(MaterialTheme.colors.background)
        ) {
            Text(
                text = stringResource(R.string.login_title),
                style = MaterialTheme.typography.h6,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(R.string.email),
                style = MaterialTheme.typography.subtitle1,
            )
            Spacer(modifier = Modifier.height(8.dp))
            EmailTextField(
                value = viewModel.emailState.value,
                onValueChange = viewModel::onEmailChange,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(R.string.password),
                style = MaterialTheme.typography.subtitle1,
            )
            Spacer(modifier = Modifier.height(8.dp))
            PasswordTextField(
                value = viewModel.passwordState.value,
                onValueChange = viewModel::onPasswordChange,
            )
            Spacer(modifier = Modifier.height(20.dp))
            BaseButton(
                text = stringResource(R.string.login_button),
                onClick = viewModel::login,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.no_account_question),
                    style = InterMedium14TextStyle,
                    color = Gray400
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = stringResource(id = R.string.create_account),
                    style = InterMedium14TextStyle,
                    color = Blue500,
                    modifier = Modifier
                        .clickable { navController.navigate(Screen.Registration.route) }
                )
            }
        }
    }
}