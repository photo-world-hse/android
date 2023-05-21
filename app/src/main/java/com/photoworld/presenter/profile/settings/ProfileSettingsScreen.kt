package com.photoworld.presenter.profile.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.photoworld.R
import com.photoworld.presenter.component.topbar.TopBar
import com.photoworld.presenter.navigation.Screen
import com.photoworld.presenter.profile.AvatarBarItem
import com.photoworld.presenter.theme.Gray700
import com.photoworld.presenter.theme.InterMedium16TextStyle

@Composable
fun ProfileSettingsScreen(
    navController: NavController,
    viewModel: ProfileSettingsViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(16.dp),
        topBar = {
            TopBar(
                title = stringResource(R.string.profile_settings),
                onBack = { navController.navigateUp() },
                onCancel = { navController.navigateUp() },
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                AvatarBarItem(
                    navController = navController,
                    url = viewModel.mainAvatarUrlState.value,
                    name = viewModel.nameState.value,
                    isProfile = false,
                )
                Spacer(modifier = Modifier.height(32.dp))
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                        .clickable { navController.navigate(Screen.PrivateInfoSettings.route) }
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Gray700)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_user),
                            contentDescription = "",
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = stringResource(id = R.string.private_data),
                        style = InterMedium16TextStyle,
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                        .clickable {  }
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Gray700)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_information),
                            contentDescription = "",
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = stringResource(id = R.string.profile_info),
                        style = InterMedium16TextStyle,
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                        .clickable {  }
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Gray700)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_services),
                            contentDescription = "",
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = stringResource(id = R.string.your_tags),
                        style = InterMedium16TextStyle,
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                        .clickable { viewModel.logout() }
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Gray700)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_logout),
                            contentDescription = "",
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = stringResource(id = R.string.logout),
                        style = InterMedium16TextStyle,
                    )
                }
            }
        },
        bottomBar = {}
    )
}