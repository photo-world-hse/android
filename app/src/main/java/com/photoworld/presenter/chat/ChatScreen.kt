package com.photoworld.presenter.chat

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.photoworld.presenter.navigation.Screen
import com.photoworld.uitls.FragmentContainer
import com.photoworld.uitls.ext.findFragmentActivity
import com.sendbird.uikit.SendbirdUIKit
import com.sendbird.uikit.fragments.ChannelFragment

@Composable
fun ChatScreen(
    navController: NavController,
    chatUrl: String? = null,
) {
    val fragmentActivity = LocalContext.current.findFragmentActivity()

    BackHandler { navController.navigate(Screen.BottomNavigationScreen.Chat.route) }

    if (chatUrl != null) {
        FragmentContainer(
            modifier = Modifier
                .fillMaxSize(),
            fragmentManager = fragmentActivity.supportFragmentManager,
            commit = { containerId ->
                add(
                    containerId,
                    ChannelFragment.Builder(chatUrl, SendbirdUIKit.ThemeMode.Dark)
                        .setCustomFragment(CustomChannelFragment())
                        .setOnHeaderLeftButtonClickListener {
                            navController.navigate(Screen.BottomNavigationScreen.Chat.route)
                        }
                        .build(),
                )
            },
        )
    }
}
