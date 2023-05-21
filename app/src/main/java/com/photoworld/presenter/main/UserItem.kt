package com.photoworld.presenter.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.photoworld.R
import com.photoworld.data.model.ProfileType
import com.photoworld.presenter.component.item.ImageItem
import com.photoworld.presenter.theme.Gray600
import com.photoworld.presenter.theme.InterMedium14TextStyle
import com.photoworld.presenter.theme.InterMedium18TextStyle

@Composable
fun UserItem(
    searchItemState: SearchItemState,
) {
    Row {
        ImageItem(
            model = searchItemState.avatarUrl,
            size = 70.dp,
            roundedCornerSize = 24.dp,
        )
        Spacer(modifier = Modifier.width(30.dp))
        Column {
            val profileRes = when(searchItemState.profileType) {
                ProfileType.PHOTOGRAPHER -> R.string.photographer
                ProfileType.MODEL -> R.string.model
                ProfileType.VISAGIST -> R.string.makeup_artist
            }
            Text(
                text = stringResource(id = profileRes),
                style = InterMedium14TextStyle,
                modifier = Modifier
                    .background(
                        color = Gray600,
                        shape = RoundedCornerShape(6.dp),
                    )
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = searchItemState.name,
                style = InterMedium18TextStyle,
            )
        }
    }
}