package com.photoworld.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.photoworld.presenter.login.LoginScreen
import com.photoworld.presenter.theme.PhotoWorldTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoWorldTheme {
                LoginScreen()
            }
        }
    }
}
