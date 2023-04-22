package com.photoworld.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.photoworld.presenter.login.LoginScreen
import com.photoworld.presenter.main.MainScreen
import com.photoworld.presenter.photosessions.PhotoSessionsScreen
import com.photoworld.presenter.profile.ProfileScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.Login.route) {
            LoginScreen()
        }
        composable(route = Screen.BottomNavigationScreen.Main.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.BottomNavigationScreen.PhotoSessions.route) {
            PhotoSessionsScreen(navController = navController)
        }
        composable(route = Screen.BottomNavigationScreen.Profile.route) {
            ProfileScreen(navController = navController)
        }
    }
}