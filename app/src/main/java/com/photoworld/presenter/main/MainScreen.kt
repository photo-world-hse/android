package com.photoworld.presenter.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.photoworld.presenter.component.bottomnavigation.BottomNavigation
import com.photoworld.presenter.component.textfield.SearchTextField
import com.photoworld.presenter.navigation.Screen

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainScreenViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding.calculateTopPadding() + 16.dp)
            ) {
                SearchTextField(
                    value = viewModel.searchState.value,
                    onValueChange = viewModel::onSearchChange,
                    onSearchClick = {},
                    onFiltersClick = {},
                )
                Spacer(modifier = Modifier.height(10.dp))
                LazyColumn(
                    modifier = Modifier.padding(bottom = 40.dp)
                ) {
                    items(viewModel.searchResultState) { searchItem ->
                        SearchItem(
                            navController = navController,
                            searchItemState = searchItem,
                        )
                    }
                }
            }
        },
        bottomBar = {
            BottomNavigation(
                selectedScreen = Screen.BottomNavigationScreen.Main,
                navController = navController,
            )
        },
    )
}