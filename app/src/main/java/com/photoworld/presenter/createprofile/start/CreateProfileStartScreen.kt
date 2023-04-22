package com.photoworld.presenter.createprofile.start

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.photoworld.R
import com.photoworld.presenter.component.button.BaseTextButton
import com.photoworld.presenter.navigation.Screen

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
                onClick = { navController.navigate(Screen.CreateProfileTag.route) },
            )
            Spacer(modifier = Modifier.height(16.dp))
            CreateProfileStartItem(
                icon = R.drawable.ic_smiley,
                text = stringResource(id = R.string.model),
                onClick = { navController.navigate(Screen.CreateProfileTag.route) },
            )
            Spacer(modifier = Modifier.height(16.dp))
            CreateProfileStartItem(
                icon = R.drawable.ic_palette,
                text = stringResource(id = R.string.makeup_artist),
                onClick = { navController.navigate(Screen.CreateProfileTag.route) },
            )
            Spacer(modifier = Modifier.height(24.dp))
            BaseTextButton(
                text = stringResource(id = R.string.skip),
                onClick = viewModel::skip
            )
        }
    }
}
