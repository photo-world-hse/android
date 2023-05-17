package com.photoworld.presenter.chat.dialogs

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.photoworld.presenter.component.bottomnavigation.BottomNavigation
import com.photoworld.presenter.navigation.Screen
import com.photoworld.uitls.FragmentContainer
import com.photoworld.uitls.ext.findFragmentActivity
import com.sendbird.uikit.SendbirdUIKit
import com.sendbird.uikit.fragments.ChannelListFragment

@Composable
fun DialogsScreen(
    navController: NavController,
) {
    val fragmentActivity = LocalContext.current.findFragmentActivity()
    Scaffold(
        bottomBar = {
            BottomNavigation(
                selectedScreen = Screen.BottomNavigationScreen.Chat,
                navController = navController,
            )
        },
    ) { paddings ->
        FragmentContainer(
            modifier = Modifier
                .padding(paddings)
                .fillMaxSize(),
            fragmentManager = fragmentActivity.supportFragmentManager,
            commit = { containerId ->
                val dialogsListFragment = DialogListFragment { chatUrl ->
                    navController.navigate(Screen.ChatScreen(chatUrl).route)
                }
                add(
                    containerId,
                    ChannelListFragment.Builder(SendbirdUIKit.ThemeMode.Dark)
                        .setCustomFragment(dialogsListFragment)
                        .build(),
                )
            },
        )
    }
}
