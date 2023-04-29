package com.photoworld.presenter.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.photoworld.R
import com.photoworld.presenter.theme.Blue600
import com.photoworld.presenter.theme.InterMedium14TextStyle
import com.photoworld.presenter.theme.InterNormal14TextStyle

@Composable
fun ProfileInfoSubScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(id = R.string.about_yourself),
            style = MaterialTheme.typography.subtitle1,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = viewModel.aboutYourselfState.value,
            style = InterNormal14TextStyle,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = R.string.tags),
            style = MaterialTheme.typography.subtitle1,
        )
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(viewModel.tagState) { tag ->
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = tag,
                    style = InterMedium14TextStyle,
                    modifier = Modifier
                        .background(
                            color = Blue600,
                            shape = RoundedCornerShape(6.dp),
                        )
                        .padding(8.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = R.string.experience),
            style = MaterialTheme.typography.subtitle1,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = viewModel.experienceState.value,
            style = InterNormal14TextStyle,
        )
    }
}