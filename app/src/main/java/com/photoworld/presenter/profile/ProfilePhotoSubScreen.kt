package com.photoworld.presenter.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.photoworld.R
import com.photoworld.presenter.component.item.TwoColumnsVerticalImageGridItem
import com.photoworld.presenter.theme.InterMedium14TextStyle

@Composable
fun ProfilePhotoSubScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(bottom = 40.dp),
        modifier = Modifier.fillMaxWidth(),
    ) {
        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(id = R.string.my_albums),
                    style = MaterialTheme.typography.subtitle1,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.file_upload),
                    contentDescription = "file_upload",
                    modifier = Modifier
                        .size(150.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(id = R.string.add_album),
                    style = InterMedium14TextStyle,
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = stringResource(id = R.string.all_photos),
                    style = MaterialTheme.typography.subtitle1,
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
        items(viewModel.photoState) { url ->
            TwoColumnsVerticalImageGridItem(model = url)
        }
    }
}