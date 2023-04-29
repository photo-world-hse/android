package com.photoworld.presenter.component.textfield

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.photoworld.R

@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onSearchClick: () -> Unit,
    onFiltersClick: () -> Unit,
    hint: String = stringResource(id = R.string.search),
    modifier: Modifier = Modifier,
) {
    BaseTextField(
        value = value,
        onValueChange = onValueChange,
        hint = hint,
        leadingIcon = {
            IconButton(onClick = onSearchClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "search"
                )
            }
        },
        trailingIcon = {
            IconButton(onClick = onFiltersClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_filters),
                    contentDescription = "filters"
                )
            }
        },
        modifier = modifier
    )
}