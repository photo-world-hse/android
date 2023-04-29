package com.photoworld.presenter.component.item

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ImageItem(
    model: String,
    size: Dp,
    roundedCornerSize: Dp = 8.dp,
    padding: Dp = 0.dp,
    modifier: Modifier = Modifier,
) {
    GlideImage(
        model = model,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .padding(padding)
            .clip(RoundedCornerShape(roundedCornerSize))
            .size(size)
    )
}