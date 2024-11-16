package com.ydhnwb.learnvoyager.page.primary

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.FadeTransition
import com.ydhnwb.learnvoyager.page.primary.parent_explore.SettingsScreen

object SettingsTab: Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Explore"
            val icon = rememberVectorPainter(Icons.Outlined.LocationOn)
            return remember {
                TabOptions(
                    index = 1u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val rootNavigator = LocalNavigator.current?.parent
        Navigator(SettingsScreen(rootNavigator)){ n ->
            FadeTransition(navigator = n)
        }
    }
}