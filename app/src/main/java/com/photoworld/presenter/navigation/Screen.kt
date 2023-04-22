package com.photoworld.presenter.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import com.photoworld.R

@Immutable
sealed class Screen(val route: String) {

    object Login : Screen(route = "login")

    object Registration : Screen(route = "registration")

    object Code : Screen(route = "code")

    object CreateProfileStart : Screen(route = "create_profile_start")

    object CreateProfileTag : Screen(route = "create_profile_tag")

    object CreateProfileAbout : Screen(route = "create_profile_about")

    @Immutable
    sealed class BottomNavigationScreen(
        route: String,
        @StringRes
        val title: Int,
        @DrawableRes
        val icon: Int,
    ) : Screen(route) {

        object Main : BottomNavigationScreen(
            route = "main",
            title = R.string.main,
            icon = R.drawable.ic_main
        )

        object PhotoSessions : BottomNavigationScreen(
            route = "photo_sessions",
            title = R.string.photo_sessions,
            icon = R.drawable.ic_camera
        )

        object Profile : BottomNavigationScreen(
            route = "profile",
            title = R.string.profile,
            icon = R.drawable.ic_user,
        )

    }
}
