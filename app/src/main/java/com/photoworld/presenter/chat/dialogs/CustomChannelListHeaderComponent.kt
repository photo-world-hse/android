package com.photoworld.presenter.chat.dialogs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.photoworld.R
import com.sendbird.uikit.modules.components.HeaderComponent

class CustomChannelListHeaderComponent : HeaderComponent() {

    override fun onCreateView(
        context: Context,
        inflater: LayoutInflater,
        parent: ViewGroup,
        savedInstanceState: Bundle?,
    ): View {
        val toolbar = ComposeView(context)
        toolbar.setContent {
            Text(
                modifier = Modifier.padding(16.dp),
                text = stringResource(id = R.string.chat),
                style = MaterialTheme.typography.h6,
            )
        }
        return toolbar
    }
}