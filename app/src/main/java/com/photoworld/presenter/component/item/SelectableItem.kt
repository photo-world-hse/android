package com.photoworld.presenter.component.item

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.photoworld.presenter.theme.Blue600
import com.photoworld.presenter.theme.InterMedium14TextStyle

@Composable
fun SelectableItem(
    text: String,
    isSelected: Boolean,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val backgroundColor = if (isSelected) {
        Blue600
    } else {
        Color.Transparent
    }
    Text(
        text = text,
        style = InterMedium14TextStyle,
        modifier = modifier
            .clickable(onClick = onSelect)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(6.dp),
            )
            .padding(8.dp)
    )
}