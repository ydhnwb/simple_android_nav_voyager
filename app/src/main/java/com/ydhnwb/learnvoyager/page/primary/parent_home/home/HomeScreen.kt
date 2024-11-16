package com.ydhnwb.learnvoyager.page.primary.parent_explore.parent_home.home

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import com.ydhnwb.learnvoyager.entity.GameType
import com.ydhnwb.learnvoyager.page.primary.parent_explore.parent_home.home.components.GameTypeItem
import com.ydhnwb.learnvoyager.page.primary.parent_home.detail.DetailScreen

class HomeScreen(val rootNavigator: Navigator?) : Screen {
    @Composable
    override fun Content() {
        val gameTypes = arrayListOf(
            GameType(id = 1, title = "Football / Soccer", description = "Generate template with 11 players on the field."),
            GameType(id = 2, title = "Futsal", description = "Generate template with 5v5 players on the field"),
        )
        GameTypeListView(gameTypes)
    }

    @Composable
    fun GameTypeListView(gameTypes: List<GameType>){
        val nav = LocalNavigator.current
        LazyColumn(
            modifier = Modifier.navigationBarsPadding(),
        ){
            items(gameTypes){ gameType ->
                GameTypeItem(item = gameType, onClick = { p ->
                    nav?.push(DetailScreen())
                })
            }
        }
    }
}