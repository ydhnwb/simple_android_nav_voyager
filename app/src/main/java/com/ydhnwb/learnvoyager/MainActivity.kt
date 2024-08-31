package com.ydhnwb.learnvoyager


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.ydhnwb.learnvoyager.ui.theme.LearnVoyagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnVoyagerTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TabNavigator(tab = HomeTab) {
                        Scaffold (
                            bottomBar = {
                                NavigationBar {
                                    TabNavItem(tab = HomeTab)
                                    TabNavItem(tab = ExploreTab)
                                }
                            }
                        ) {
                            Box(modifier = Modifier.padding(bottom = it.calculateBottomPadding()))
                            CurrentTab()
                        }
                    }
                }

            }
        }
    }
}


// kotlin extension func
@Composable
private  fun RowScope.TabNavItem(tab: Tab) {
    val tabNav = LocalTabNavigator.current
    NavigationBarItem(
        selected = tabNav.current == tab,
        onClick = {
            tabNav.current = tab
        },
        icon = {
            tab.options.icon?.let { p ->
                Icon(painter = p, contentDescription = tab.options.title)
            }
        },
        label = {
            Text(text = tab.options.title)
        }
    )
}
