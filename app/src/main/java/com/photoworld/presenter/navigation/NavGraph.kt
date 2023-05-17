package com.photoworld.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.photoworld.presenter.code.CodeScreen
import com.photoworld.presenter.createprofile.about.CreateProfileAboutScreen
import com.photoworld.presenter.createprofile.avatar.CreateProfileAvatarScreen
import com.photoworld.presenter.createprofile.image.CreateProfileImageScreen
import com.photoworld.presenter.createprofile.start.CreateProfileStartScreen
import com.photoworld.presenter.createprofile.tag.CreateProfileTagScreen
import com.photoworld.presenter.login.LoginScreen
import com.photoworld.presenter.main.MainScreen
import com.photoworld.presenter.photosessions.PhotoSessionsScreen
import com.photoworld.presenter.photosessions.create.image.CreatePhotoSessionImageScreen
import com.photoworld.presenter.photosessions.create.info.CreatePhotoSessionInfoScreen
import com.photoworld.presenter.photosessions.details.PhotoSessionDetailsScreen
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
        composable(
            route = Screen.Code.BASE_ROUTE,
            arguments = listOf(
                navArgument(Screen.Code.EMAIL_ARGUMENT) { type = NavType.StringType }
            )
        ) {
            CodeScreen(navController = navController)
        }
        composable(route = Screen.CreateProfileStart.route) {
            CreateProfileStartScreen(navController = navController)
        }
        composable(
            route = Screen.CreateProfileTag.BASE_ROUTE,
            arguments = listOf(
                navArgument(Screen.CreateProfileTag.PROFILE_TYPE_ARGUMENT) {
                    type = NavType.StringType
                }
            )
        ) {
            CreateProfileTagScreen(navController = navController)
        }
        composable(
            route = Screen.CreateProfileAbout.BASE_ROUTE,
            arguments = listOf(
                navArgument(Screen.CreateProfileAbout.PROFILE_TYPE_ARGUMENT) {
                    type = NavType.StringType
                }
            )
        ) {
            CreateProfileAboutScreen(navController = navController)
        }
        composable(
            route = Screen.CreateProfileImage.BASE_ROUTE,
            arguments = listOf(
                navArgument(Screen.CreateProfileImage.PROFILE_TYPE_ARGUMENT) {
                    type = NavType.StringType
                }
            )
        ) {
            CreateProfileImageScreen(navController = navController)
        }
        composable(
            route = Screen.CreateProfileAvatar.BASE_ROUTE,
            arguments = listOf(
                navArgument(Screen.CreateProfileAvatar.PROFILE_TYPE_ARGUMENT) {
                    type = NavType.StringType
                }
            )
        ) {
            CreateProfileAvatarScreen(navController = navController)
        }
        composable(route = Screen.CreatePhotoSessionInfo.route) {
            CreatePhotoSessionInfoScreen(navController = navController)
        }
        composable(route = Screen.CreatePhotoSessionImage.route) {
            CreatePhotoSessionImageScreen(navController = navController)
        }
        composable(route = Screen.PhotoSessionDetails.route) {
            PhotoSessionDetailsScreen(navController = navController)
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