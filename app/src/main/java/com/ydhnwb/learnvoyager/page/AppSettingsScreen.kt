package com.ydhnwb.learnvoyager.page

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class AppSettingsScreen: Screen {
    @Composable
    override fun Content() {
        Text("APp preference settings")
    }
}