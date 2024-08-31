package com.ydhnwb.learnvoyager

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.FadeTransition

object ExploreTab: Tab {
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
        Navigator(Screen1()){ n ->
            FadeTransition(navigator = n)
        }
    }
}