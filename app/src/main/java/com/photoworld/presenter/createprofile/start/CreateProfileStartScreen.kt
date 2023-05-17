package com.photoworld.presenter.createprofile.start

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.photoworld.R
import com.photoworld.data.model.ProfileType
import com.photoworld.presenter.component.button.BaseTextButton
import com.photoworld.presenter.component.progressindicator.ProgressIndicator

@Composable
fun CreateProfileStartScreen(
    navController: NavController,
    viewModel: CreateProfileStartViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(16.dp)
    ) { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            if (viewModel.isLoadingState.value) {
                ProgressIndicator()
            } else {
                Image(
                    painter = painterResource(id = R.drawable.create_profile),
                    contentDescription = "Create Profile",
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = stringResource(id = R.string.what_do_you_do),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(24.dp))
                CreateProfileStartItem(
                    icon = R.drawable.ic_camera,
                    text = stringResource(id = R.string.photographer),
                    onClick = { viewModel.createProfile(ProfileType.PHOTOGRAPHER) },
                )
                Spacer(modifier = Modifier.height(16.dp))
                CreateProfileStartItem(
                    icon = R.drawable.ic_smiley,
                    text = stringResource(id = R.string.model),
                    onClick = { viewModel.createProfile(ProfileType.MODEL) },
                )
                Spacer(modifier = Modifier.height(16.dp))
                CreateProfileStartItem(
                    icon = R.drawable.ic_palette,
                    text = stringResource(id = R.string.makeup_artist),
                    onClick = { viewModel.createProfile(ProfileType.VISAGIST) },
                )
                Spacer(modifier = Modifier.height(24.dp))
                BaseTextButton(
                    text = stringResource(id = R.string.skip),
                    onClick = viewModel::skip
                )
            }
        }
    }
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel
            .toastMessage
            .collect { message ->
                Toast.makeText(
                    context,
                    context.getText(message),
                    Toast.LENGTH_SHORT,
                ).show()
            }
    }
}
