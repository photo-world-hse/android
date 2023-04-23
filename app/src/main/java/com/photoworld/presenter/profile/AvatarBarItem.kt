package com.photoworld.presenter.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.photoworld.R
import com.photoworld.presenter.component.button.BaseButton
import com.photoworld.presenter.theme.Blue500
import com.photoworld.presenter.theme.Gray500
import com.photoworld.presenter.theme.Gray700
import com.photoworld.presenter.theme.InterNormal14TextStyle

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AvatarBarItem(
    viewModel: ProfileViewModel = hiltViewModel(),
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Box(
            Modifier
                .padding(top = 35.dp)
                .background(
                    color = Gray700,
                    shape = RoundedCornerShape(8.dp),
                )
                .height(180.dp)
                .fillMaxWidth()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.add_profile),
                    contentDescription = "add_profile",
                )
                Spacer(modifier = Modifier.width(8.dp))
                GlideImage(
                    model = viewModel.mainAvatarUrlState.value,
                    contentDescription = "main_avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .border(
                            width = 3.dp,
                            color = Blue500,
                            shape = RoundedCornerShape(30.dp),
                        )
                        .clip(RoundedCornerShape(30.dp))
                        .size(90.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.add_profile),
                    contentDescription = "add_profile",
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = viewModel.nameState.value,
                style = MaterialTheme.typography.subtitle1,
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = stringResource(id = R.string.photographer),
                style = InterNormal14TextStyle,
            )
            Spacer(modifier = Modifier.height(5.dp))
            BaseButton(
                text = stringResource(R.string.profile_settings),
                backgroundColor = Gray500,
                contentPadding = ButtonDefaults.ContentPadding,
                onClick = {},
            )
        }
    }
}