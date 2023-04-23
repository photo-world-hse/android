package com.photoworld.presenter.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.photoworld.presenter.theme.Blue600
import com.photoworld.presenter.theme.InterMedium16TextStyle

@Composable
fun BaseButton(
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color = Blue600,
    contentPadding: PaddingValues = PaddingValues(18.dp),
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
        contentPadding = contentPadding,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            style = InterMedium16TextStyle,
        )
    }
}