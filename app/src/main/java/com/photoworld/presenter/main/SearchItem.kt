package com.photoworld.presenter.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.photoworld.R
import com.photoworld.presenter.component.button.BaseButton
import com.photoworld.presenter.theme.Gray600
import com.photoworld.presenter.theme.InterMedium14TextStyle
import com.photoworld.presenter.theme.InterMedium18TextStyle

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SearchItem(
    navController: NavController,
    searchItemState: SearchItemState,
) {
    Column(
        modifier = Modifier
            .padding(vertical = 10.dp)
    ) {
        Row {
            GlideImage(
                model = searchItemState.avatarUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(24.dp))
                    .size(70.dp)
            )
            Spacer(modifier = Modifier.width(30.dp))
            Column {
                Text(
                    text = stringResource(id = R.string.model),
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
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(id = R.string.photos),
            style = InterMedium18TextStyle,
        )
        LazyRow {
            items(searchItemState.photoUrls) { photoUrl ->
                GlideImage(
                    model = photoUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(6.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .size(120.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        BaseButton(
            text = stringResource(R.string.add_button),
            contentPadding = ButtonDefaults.ContentPadding,
            onClick = { navController.navigateUp() },
        )
    }
}