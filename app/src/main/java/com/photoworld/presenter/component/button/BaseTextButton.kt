package com.photoworld.presenter.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.photoworld.presenter.theme.Blue500
import com.photoworld.presenter.theme.InterMedium16TextStyle

@Composable
fun BaseTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TextButton(
        onClick = onClick,
        contentPadding = PaddingValues(18.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            style = InterMedium16TextStyle,
            color = Blue500,
        )
    }
}