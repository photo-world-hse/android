package com.photoworld.presenter.component.bottomnavigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.photoworld.presenter.navigation.Screen
import com.photoworld.presenter.theme.Blue500
import com.photoworld.presenter.theme.Gray400
import com.photoworld.presenter.theme.Gray900
import com.photoworld.presenter.theme.InterSemiBold10TextStyle

@Composable
fun BottomNavigation(
    selectedScreen: Screen.BottomNavigationScreen,
    navController: NavController,
) {
    val items = listOf(
        Screen.BottomNavigationScreen.Main,
        Screen.BottomNavigationScreen.PhotoSessions,
        Screen.BottomNavigationScreen.Profile,
    )
    BottomNavigation(
        backgroundColor = Gray900,
    ) {
        items.forEach { item ->
            val selected = item.route == selectedScreen.route
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = stringResource(item.title),
                    )
                },
                label = {
                    Text(
                        text = stringResource(item.title),
                        style = InterSemiBold10TextStyle,
                        color = if (selected) {
                            Blue500
                        } else {
                            Gray400
                        }
                    )
                },
                selectedContentColor = Blue500,
                unselectedContentColor = Gray400,
                alwaysShowLabel = true,
                selected = selected,
                onClick = { navController.navigate(item.route) }
            )
        }
    }
}