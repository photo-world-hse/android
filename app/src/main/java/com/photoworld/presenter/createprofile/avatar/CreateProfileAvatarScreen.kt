package com.photoworld.presenter.createprofile.avatar

import android.Manifest
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.photoworld.R
import com.photoworld.presenter.component.button.BaseButton
import com.photoworld.presenter.component.button.BaseTextButton
import com.photoworld.presenter.component.item.ImageItem
import com.photoworld.presenter.component.topbar.TopBar
import com.photoworld.presenter.theme.Gray400
import com.photoworld.presenter.theme.InterNormal14TextStyle
import com.photoworld.presenter.util.getMultipartBodyByUri

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CreateProfileAvatarScreen(
    navController: NavController,
    viewModel: CreateProfileAvatarViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            uri?.let {
                val multipartBody = context.getMultipartBodyByUri(uri)
                viewModel.onNewImage(multipartBody)
            }
        }
    )
    val readExternalStoragePermissionState =
        rememberPermissionState(Manifest.permission.READ_EXTERNAL_STORAGE)

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
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = stringResource(id = R.string.add_avatar_title),
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(id = R.string.add_avatar_info),
                    style = InterNormal14TextStyle,
                    color = Gray400,
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.height(64.dp))
                if (viewModel.imageState.value.isBlank()) {
                    Image(
                        painter = painterResource(id = R.drawable.file_upload),
                        contentDescription = "file_upload",
                    )
                } else {
                    ImageItem(
                        model = viewModel.imageState.value,
                        size = 230.dp,
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                BaseTextButton(
                    text = stringResource(R.string.add_avatar),
                    onClick = {
                        when {
                            readExternalStoragePermissionState.status.isGranted ->
                                galleryLauncher.launch("image/*")
                            readExternalStoragePermissionState.status.shouldShowRationale ->
                                readExternalStoragePermissionState.launchPermissionRequest()
                            else -> Toast.makeText(
                                context,
                                R.string.need_read_external_storage_permission,
                                Toast.LENGTH_SHORT,
                            ).show()
                        }
                    },
                )
            }
        },
        bottomBar = {
            BaseButton(
                text = stringResource(R.string.continue_button),
                onClick = viewModel::nextScreen,
            )
        }
    )
    LaunchedEffect(Unit) {
        readExternalStoragePermissionState.launchPermissionRequest()
    }
}
