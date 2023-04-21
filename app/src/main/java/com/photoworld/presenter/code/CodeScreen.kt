package com.photoworld.presenter.code

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.photoworld.presenter.theme.Blue500
import com.photoworld.presenter.theme.Gray200
import com.photoworld.presenter.theme.InterNormal14TextStyle

@Composable
fun CodeScreen(
    navController: NavController,
    viewModel: CodeViewModel = hiltViewModel()
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
            TopBar(
                title = stringResource(R.string.code_title),
                onBack = { navController.navigateUp() },
                onCancel = { navController.navigateUp() },
            )
            Spacer(modifier = Modifier.height(40.dp))
            Row {
                Text(
                    text = stringResource(R.string.on_your_email),
                    style = InterNormal14TextStyle,
                    color = Gray200,
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = viewModel.emailState.value,
                    style = InterNormal14TextStyle,
                    color = Blue500,
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = stringResource(R.string.code_send),
                style = InterNormal14TextStyle,
                color = Gray200,
            )
            Spacer(modifier = Modifier.height(16.dp))
            BaseTextField(
                value = viewModel.codeState.value,
                onValueChange = viewModel::onCodeChange,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                hint = stringResource(id = R.string.code_hint)
            )
            Spacer(modifier = Modifier.weight(1f))
            BaseButton(
                text = stringResource(R.string.confirm_button),
                onClick = viewModel::login,
            )
        }
    }
}
