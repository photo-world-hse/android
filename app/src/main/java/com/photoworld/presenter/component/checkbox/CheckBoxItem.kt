package com.photoworld.presenter.component.checkbox

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.photoworld.R
import com.photoworld.presenter.theme.Gray300
import com.photoworld.presenter.theme.InterMedium16TextStyle

@Composable
fun CheckBoxItem(
    isChecked: Boolean,
    text: String,
    onClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(
                horizontal = 0.dp,
                vertical = 15.dp,
            )
    ) {
        if (isChecked) {
            Image(
                painter = painterResource(id = R.drawable.ic_checked),
                contentDescription = "checked",
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.ic_unchecked),
                contentDescription = "unchecked",
            )
        }
        Spacer(modifier = Modifier.width(14.dp))
        Text(
            text = text,
            style = InterMedium16TextStyle,
            color = Gray300,
        )
    }
}