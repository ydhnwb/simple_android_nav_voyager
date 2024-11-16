package com.ydhnwb.learnvoyager.page.primary

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.FadeTransition
import com.ydhnwb.learnvoyager.page.primary.parent_explore.parent_home.home.HomeScreen


/***
 * This is the parent view of home tab.
 * Every pages inside this should be added on HomeScren(), look at below.
 */

object HomeTab: Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Home"
            val icon = rememberVectorPainter(Icons.Outlined.Home)
            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val rootNavigator = LocalNavigator.current?.parent
        Navigator(HomeScreen(rootNavigator)){ n ->
            FadeTransition(navigator = n )
        }
    }
}