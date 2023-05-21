package com.photoworld.presenter.main.filters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.photoworld.R
import com.photoworld.data.model.ProfileType
import com.photoworld.presenter.component.button.BaseButton
import com.photoworld.presenter.component.checkbox.CheckBoxItem
import com.photoworld.presenter.component.item.SelectableItem
import com.photoworld.presenter.component.progressindicator.ProgressIndicator
import com.photoworld.presenter.component.textfield.BaseTextField
import com.photoworld.presenter.component.topbar.TopBar
import com.photoworld.presenter.theme.InterMedium18TextStyle

@Composable
fun FiltersScreen(
    navController: NavController,
    viewModel: FiltersViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(16.dp),
        topBar = {
            TopBar(
                title = stringResource(R.string.filters),
                onBack = { navController.navigateUp() },
                onCancel = { navController.navigateUp() },
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                if (viewModel.isLoadingState.value) {
                    ProgressIndicator()
                } else {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.category),
                        style = InterMedium18TextStyle,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        SelectableItem(
                            text = stringResource(id = R.string.all),
                            isSelected = viewModel.selectedTypeState.value == null,
                            onSelect = { viewModel.onSelectedTypeChange(null) },
                        )
                        SelectableItem(
                            text = stringResource(id = R.string.photographer),
                            isSelected = viewModel.selectedTypeState.value == ProfileType.PHOTOGRAPHER,
                            onSelect = { viewModel.onSelectedTypeChange(ProfileType.PHOTOGRAPHER) },
                        )
                        SelectableItem(
                            text = stringResource(id = R.string.model),
                            isSelected = viewModel.selectedTypeState.value == ProfileType.MODEL,
                            onSelect = { viewModel.onSelectedTypeChange(ProfileType.MODEL) },
                        )
                        SelectableItem(
                            text = stringResource(id = R.string.makeup_artist),
                            isSelected = viewModel.selectedTypeState.value == ProfileType.VISAGIST,
                            onSelect = { viewModel.onSelectedTypeChange(ProfileType.VISAGIST) },
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.experience),
                        style = InterMedium18TextStyle,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        BaseTextField(
                            value = viewModel.experienceFromState.value,
                            onValueChange = viewModel::onExperienceFromChange,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            hint = stringResource(id = R.string.from),
                            modifier = Modifier
                                .weight(weight = 0.4F)
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        BaseTextField(
                            value = viewModel.experienceToState.value,
                            onValueChange = viewModel::onExperienceToChange,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            hint = stringResource(id = R.string.to),
                            modifier = Modifier
                                .weight(weight = 0.4F)
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.rating_from),
                        style = InterMedium18TextStyle,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    BaseTextField(
                        value = viewModel.ratingState.value,
                        onValueChange = viewModel::onRatingChange,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    )
                    if (viewModel.selectedTypeState.value != null) {
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = stringResource(id = R.string.tags),
                            style = InterMedium18TextStyle,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        LazyColumn {
                            val items = viewModel.tagsState[viewModel.selectedTypeState.value]
                                ?: emptyList()
                            itemsIndexed(items) { index, tag ->
                                CheckBoxItem(isChecked = tag.isSelected, text = tag.text) {
                                    viewModel.onCheckChange(index)
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        },
        bottomBar = {
            if (!viewModel.isLoadingState.value) {
                BaseButton(
                    text = stringResource(R.string.save),
                    onClick = viewModel::save,
                )
            }
        }
    )
}
