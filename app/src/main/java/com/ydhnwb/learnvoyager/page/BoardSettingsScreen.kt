package com.ydhnwb.learnvoyager.page

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class BoardSettingsScreen : Screen {
    @Composable
    override fun Content() {
        val r = LocalNavigator.current
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.clickable {
                    r?.pop()
                }
            ) {
                Text("Hello board settings page")
            }
        }
    }
}