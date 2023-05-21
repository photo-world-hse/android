package com.photoworld.presenter.chat.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.photoworld.R
import com.photoworld.presenter.component.item.ImageItem
import com.photoworld.presenter.component.textfield.BaseTextField
import com.photoworld.presenter.theme.Gray400
import com.photoworld.presenter.theme.Gray600
import com.photoworld.presenter.theme.Gray900
import com.photoworld.presenter.theme.InterMedium14TextStyle

@Composable
fun DialogScreen(
    navController: NavController,
    viewModel: DialogViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(0.dp),
        topBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                IconButton(onClick = navController::navigateUp) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "back",
                        tint = Gray400,
                    )
                }
                ImageItem(
                    model = viewModel.usersState.value.avatarUrl,
                    size = 40.dp,
                    padding = 6.dp,
                )
                Text(
                    text = viewModel.usersState.value.name,
                    style = InterMedium14TextStyle,
                    modifier = Modifier
                        .align(Alignment.Top)
                        .padding(horizontal = 2.dp, vertical = 10.dp)
                )
            }
        },
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                LazyColumn(
                    reverseLayout = true,
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    items(viewModel.messagesState) { message ->
                        Spacer(modifier = Modifier.height(4.dp))
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .background(Gray600)
                        ) {
                            Text(
                                text = message,
                                style = InterMedium14TextStyle,
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }
        },
        bottomBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
                    .background(color = Gray900)
                    .padding(16.dp)
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add_file),
                        contentDescription = "add_file",
                        tint = Gray400,
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                BaseTextField(
                    value = viewModel.messageState.value,
                    onValueChange = viewModel::onMessageChange,
                    hint = stringResource(id = R.string.message),
                    modifier = Modifier.weight(1F)
                )
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(onClick = viewModel::send) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_send),
                        contentDescription = "send",
                        tint = Gray400,
                    )
                }
            }
        }
    )
}