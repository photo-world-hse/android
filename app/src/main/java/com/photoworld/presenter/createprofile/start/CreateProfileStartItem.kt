package com.photoworld.presenter.createprofile.start

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.photoworld.presenter.theme.Blue500
import com.photoworld.presenter.theme.Gray700
import com.photoworld.presenter.theme.InterMedium16TextStyle

@Composable
fun CreateProfileStartItem(
    @DrawableRes
    icon: Int,
    text: String,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Gray700,
                shape = RoundedCornerShape(8.dp),
            )
            .clickable(onClick = onClick)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(
                    horizontal = 18.dp,
                    vertical = 15.dp
                )
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "camera",
                tint = Blue500,
            )
            Spacer(modifier = Modifier.width(18.dp))
            Text(
                text = text,
                style = InterMedium16TextStyle,
            )
        }
    }
}
