package com.photoworld.presenter.navigation

import androidx.navigation.NavHostController

class NavigationManager {

    private var navController: NavHostController? = null

    fun setNavController(navController: NavHostController) {
        this.navController = navController
    }

    fun deleteNavController() {
        this.navController = null
    }

    fun navigateUp() {
        navController?.navigateUp()
    }

    fun navigate(route: String) {
        navController?.navigate(route = route)
    }

    fun replace(route: String) {
        navController?.let { navController ->
            navController.navigate(route = route) {
                popUpTo(
                    navController.previousBackStackEntry?.destination?.id
                        ?: navController.graph.startDestinationId
                )
            }
        }
    }

    fun newRoot(route: String) {
        navController?.let { navController ->
            navController.navigate(route = route) {
                popUpTo(navController.graph.startDestinationId) {
                    inclusive = true
                }
            }
            navController.graph.setStartDestination(route)
        }
    }
}