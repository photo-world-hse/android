package com.photoworld.presenter.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import com.photoworld.R

@Immutable
sealed class Screen(val route: String) {

    object Login : Screen(route = "login")

    object Registration : Screen(route = "registration")

    class Code(email: String) : Screen(route = "$SCREEN_NAME/$email") {
        companion object {
            const val SCREEN_NAME = "email"
            const val EMAIL_ARGUMENT = "email"
            const val BASE_ROUTE = "$SCREEN_NAME/{$EMAIL_ARGUMENT}"
        }
    }

    object CreateProfileStart : Screen(route = "create_profile_start")

    class CreateProfileTag(profileType: String) : Screen(route = "$SCREEN_NAME/$profileType") {
        companion object {
            const val SCREEN_NAME = "create_profile_tag"
            const val PROFILE_TYPE_ARGUMENT = "profile_type"
            const val BASE_ROUTE = "$SCREEN_NAME/{$PROFILE_TYPE_ARGUMENT}"
        }
    }

    class CreateProfileAbout(profileType: String) : Screen(route = "$SCREEN_NAME/$profileType") {
        companion object {
            const val SCREEN_NAME = "create_profile_about"
            const val PROFILE_TYPE_ARGUMENT = "profile_type"
            const val BASE_ROUTE = "$SCREEN_NAME/{$PROFILE_TYPE_ARGUMENT}"
        }
    }

    class CreateProfileImage(profileType: String) : Screen(route = "$SCREEN_NAME/$profileType") {
        companion object {
            const val SCREEN_NAME = "create_profile_image"
            const val PROFILE_TYPE_ARGUMENT = "profile_type"
            const val BASE_ROUTE = "$SCREEN_NAME/{$PROFILE_TYPE_ARGUMENT}"
        }
    }

    class CreateProfileAvatar(profileType: String) : Screen(route = "$SCREEN_NAME/$profileType") {
        companion object {
            const val SCREEN_NAME = "create_profile_avatar"
            const val PROFILE_TYPE_ARGUMENT = "profile_type"
            const val BASE_ROUTE = "$SCREEN_NAME/{$PROFILE_TYPE_ARGUMENT}"
        }
    }

    object CreatePhotoSessionInfo : Screen(route = "create_photo_session_info")

    object CreatePhotoSessionImage : Screen(route = "create_photo_session_image")

    object PhotoSessionDetails : Screen(route = "photo_session_details")

    data class ChatScreen(val chatUrl: String) : Screen(route = getRouteWithArgs(chatUrl)) {

        companion object {

            private const val ROUTE = "chat_screen"
            const val CHAT_URL_ARG = "chatUrl"
            const val ROUTE_WITH_ARGS = "$ROUTE?$CHAT_URL_ARG={$CHAT_URL_ARG}"

            fun getRouteWithArgs(chatUrl: String): String =
                ROUTE_WITH_ARGS.replace("{$CHAT_URL_ARG}", chatUrl)
        }
    }

    object Filters : Screen(route = "filters")

    object FinishPhotoSession : Screen(route = "finish_photo_session")

    object Feedback : Screen(route = "feedback")

    object Dialog : Screen(route = "dialog")

    object FinishPhotos : Screen(route = "finish_photos")

    object ProfileSettings : Screen(route = "profile_settings")

    object PrivateInfoSettings : Screen(route = "private_info_settings")

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
            icon = R.drawable.ic_main,
        )

        object PhotoSessions : BottomNavigationScreen(
            route = "photo_sessions",
            title = R.string.photo_sessions,
            icon = R.drawable.ic_camera,
        )

        object Chat : BottomNavigationScreen(
            route = "chats",
            title = R.string.chat,
            icon = R.drawable.ic_chat,
        )

        object Profile : BottomNavigationScreen(
            route = "profile",
            title = R.string.profile,
            icon = R.drawable.ic_user,
        )

    }
}
