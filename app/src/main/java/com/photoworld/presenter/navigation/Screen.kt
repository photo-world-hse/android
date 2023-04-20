package com.photoworld.presenter.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.photoworld.R

sealed class Screen(val route: String) {

    object Login : Screen(route = "login")

    object Test : Screen(route = "test_screen")

    object Test2 : Screen(route = "test2_screen")

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
