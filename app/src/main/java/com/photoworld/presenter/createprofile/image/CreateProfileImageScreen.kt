package com.photoworld.presenter.createprofile.image

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.photoworld.R
import com.photoworld.presenter.component.button.BaseButton
import com.photoworld.presenter.component.topbar.TopBar
import com.photoworld.presenter.theme.Gray500

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CreateProfileImageScreen(
    navController: NavController,
    viewModel: CreateProfileImageViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(16.dp),
        topBar = {
            TopBar(
                title = stringResource(R.string.create_profile_title),
                onBack = { navController.navigateUp() },
                onCancel = viewModel::cancel,
            )
        },
        content = { padding ->
            val galleryLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.GetContent(),
                onResult = viewModel::onNewImage
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                BaseButton(
                    text = stringResource(R.string.add_photo),
                    backgroundColor = Gray500,
                    onClick = {
                        galleryLauncher.launch("image/*")
                    },
                )
                LazyVerticalGrid(
                    columns = GridCells.Fixed(count = 2),
                    modifier = Modifier
                        .padding(vertical = 20.dp),
                ) {
                    items(viewModel.imageState) { uri ->
                        GlideImage(
                            model = uri,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(4.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .aspectRatio(1f)
                                .fillMaxSize()
                        )
                    }
                }
            }
        },
        bottomBar = {
            BaseButton(
                text = stringResource(R.string.continue_button),
                onClick = viewModel::nextScreen,
            )
        }
    )
}
