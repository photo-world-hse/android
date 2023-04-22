package com.photoworld.presenter

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import com.photoworld.presenter.navigation.SetupNavGraph
import com.photoworld.presenter.theme.PhotoWorldTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    lateinit var navController: NavHostController

    @Inject
    lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoWorldTheme {
                navController = rememberNavController()
                navigationManager.setNavController(navController)
                SetupNavGraph(
                    navController = navController,
                    startDestination = Screen.Login.route
                )
            }
        }
    }

    override fun onDestroy() {
        navigationManager.deleteNavController()
        super.onDestroy()
    }

}
