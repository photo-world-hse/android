package com.photoworld.presenter.component.grid

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.photoworld.presenter.component.item.TwoColumnsVerticalImageGridItem

@Composable
fun TwoColumnsVerticalImageGrid(
    uris: List<String>,
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 2),
        modifier = Modifier
            .padding(vertical = 20.dp),
    ) {
        items(uris) { uri ->
            TwoColumnsVerticalImageGridItem(model = uri)
        }
    }

}