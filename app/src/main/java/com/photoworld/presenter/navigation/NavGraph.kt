package com.photoworld.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.photoworld.presenter.code.CodeScreen
import com.photoworld.presenter.createprofile.about.CreateProfileAboutScreen
import com.photoworld.presenter.createprofile.avatar.CreateProfileAvatarScreen
import com.photoworld.presenter.createprofile.image.CreateProfileImageScreen
import com.photoworld.presenter.createprofile.start.CreateProfileStartScreen
import com.photoworld.presenter.createprofile.tag.CreateProfileTagScreen
import com.photoworld.presenter.login.LoginScreen
import com.photoworld.presenter.main.MainScreen
import com.photoworld.presenter.photosessions.PhotoSessionsScreen
import com.photoworld.presenter.profile.ProfileScreen
import com.photoworld.presenter.registration.RegistrationScreen

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
            LoginScreen(navController = navController)
        }
        composable(route = Screen.Registration.route) {
            RegistrationScreen(navController = navController)
        }
        composable(route = Screen.Code.route) {
            CodeScreen(navController = navController)
        }
        composable(route = Screen.CreateProfileStart.route) {
            CreateProfileStartScreen(navController = navController)
        }
        composable(route = Screen.CreateProfileTag.route) {
            CreateProfileTagScreen(navController = navController)
        }
        composable(route = Screen.CreateProfileAbout.route) {
            CreateProfileAboutScreen(navController = navController)
        }
        composable(route = Screen.CreateProfileImage.route) {
            CreateProfileImageScreen(navController = navController)
        }
        composable(route = Screen.CreateProfileAvatar.route) {
            CreateProfileAvatarScreen(navController = navController)
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