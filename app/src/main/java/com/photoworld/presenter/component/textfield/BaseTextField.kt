package com.photoworld.presenter.component.textfield

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.photoworld.presenter.theme.Blue600
import com.photoworld.presenter.theme.Gray500
import com.photoworld.presenter.theme.Gray700
import com.photoworld.presenter.theme.InterMedium14TextStyle
import com.photoworld.presenter.theme.White

@Composable
fun BaseTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String = "",
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = InterMedium14TextStyle,
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Blue600,
            unfocusedBorderColor = Gray700,
            backgroundColor = Gray700,
            cursorColor = White,
        ),
        trailingIcon = trailingIcon,
        placeholder = {
            Row {
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = hint,
                    color = Gray500,
                    style = InterMedium14TextStyle
                )
            }
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        modifier = modifier
            .fillMaxWidth()
    )
}