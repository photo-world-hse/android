package com.photoworld.presenter.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.photoworld.R
import com.photoworld.presenter.component.bottomnavigation.BottomNavigation
import com.photoworld.presenter.navigation.Screen

@Composable
fun MainScreen(
    navController: NavController,
) {
    Scaffold(
        bottomBar = {
            BottomNavigation(
                selectedScreen = Screen.BottomNavigationScreen.Main,
                navController = navController,
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
        ) {
            Text(text = stringResource(id = R.string.main))
        }
    }
}