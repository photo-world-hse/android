package com.photoworld.presenter.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.photoworld.R
import com.photoworld.presenter.component.button.BaseButton
import com.photoworld.presenter.component.item.ImageItem
import com.photoworld.presenter.theme.Gray900
import com.photoworld.presenter.theme.InterMedium18TextStyle
import com.photoworld.presenter.theme.White

@Composable
fun SearchItem(
    navController: NavController,
    searchItemState: SearchItemState,
    isAdd: Boolean,
    onAdd: (SearchItemState) -> Unit,
    onChat: (SearchItemState) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(vertical = 10.dp)
    ) {
        UserItem(searchItemState = searchItemState)
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(id = R.string.photos),
            style = InterMedium18TextStyle,
        )
        LazyRow {
            items(searchItemState.photoUrls) { photoUrl ->
                ImageItem(
                    model = photoUrl,
                    size = 120.dp,
                    padding = 6.dp,
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        if (isAdd) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                BaseButton(
                    text = stringResource(R.string.write),
                    contentPadding = ButtonDefaults.ContentPadding,
                    onClick = { onChat(searchItemState) },
                    modifier = Modifier.weight(0.5F),
                )
                Spacer(modifier = Modifier.width(8.dp))
                BaseButton(
                    text = stringResource(R.string.add_button),
                    contentPadding = ButtonDefaults.ContentPadding,
                    backgroundColor = White,
                    contentColor = Gray900,
                    onClick = { onAdd(searchItemState) },
                    modifier = Modifier.weight(0.5F),
                )
            }
        } else {
            BaseButton(
                text = stringResource(R.string.write),
                contentPadding = ButtonDefaults.ContentPadding,
                onClick = { onChat(searchItemState) },
            )
        }
    }
}