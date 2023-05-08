package com.photoworld.presenter.component.textfield

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.photoworld.R

@Composable
fun EmailTextField(
    value: String,
    onValueChange: (String) -> Unit,
    error: String = "",
    modifier: Modifier = Modifier,
) {
    BaseTextField(
        value = value,
        onValueChange = onValueChange,
        hint = stringResource(id = R.string.email_hint),
        topLabel = stringResource(id = R.string.email),
        error = error,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        modifier = modifier
    )
}