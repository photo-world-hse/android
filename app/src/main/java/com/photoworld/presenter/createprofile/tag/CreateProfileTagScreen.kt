package com.photoworld.presenter.createprofile.tag

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.photoworld.R
import com.photoworld.presenter.component.button.BaseButton
import com.photoworld.presenter.component.checkbox.CheckBoxItem
import com.photoworld.presenter.component.topbar.TopBar
import com.photoworld.presenter.theme.Gray400
import com.photoworld.presenter.theme.InterMedium18TextStyle
import com.photoworld.presenter.theme.InterNormal14TextStyle

@Composable
fun CreateProfileTagScreen(
    navController: NavController,
    viewModel: CreateProfileTagViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(16.dp),
        topBar = {
            TopBar(
                title = stringResource(R.string.create_profile_title),
                onBack = { navController.navigateUp() },
                onCancel = viewModel::cancel,
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = stringResource(id = R.string.your_tags),
                    style = InterMedium18TextStyle,
                )
                Text(
                    text = stringResource(id = R.string.tags_info),
                    style = InterNormal14TextStyle,
                    color = Gray400,
                )
                LazyColumn {
                    itemsIndexed(viewModel.tagsState) { index, tag ->
                        CheckBoxItem(isChecked = tag.isSelected, text = tag.text) {
                            viewModel.onCheckChange(index)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        },
        bottomBar = {
            BaseButton(
                text = stringResource(R.string.continue_button),
                onClick = viewModel::nextScreen,
            )
        }
    )
}
