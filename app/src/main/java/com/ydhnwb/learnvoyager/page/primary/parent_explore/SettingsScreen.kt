package com.ydhnwb.learnvoyager.page.primary.parent_explore


import android.annotation.SuppressLint
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import com.ydhnwb.learnvoyager.entity.SettingType
import com.ydhnwb.learnvoyager.entity.settingsData
import com.ydhnwb.learnvoyager.page.AboutAppScreen
import com.ydhnwb.learnvoyager.page.AppPermissionScreen
import com.ydhnwb.learnvoyager.page.BoardSettingsScreen
import com.ydhnwb.learnvoyager.page.DonateScreen
import com.ydhnwb.learnvoyager.page.primary.parent_explore.components.SettingsItemComponent

@OptIn(ExperimentalMaterial3Api::class)
class SettingsScreen(val rootNavigator: Navigator?) : Screen {

    @Composable
    override fun Content() {
        val scrollState = rememberScrollState()
        val searchQuery = remember { mutableStateOf("") }
        val settings = remember { mutableStateOf(settingsData.toList()) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            SearchHeader(searchQuery)
            ListSetting(scrollState, settings, searchQuery)

        }

    }


    @Composable
    fun SearchHeader(searchQuery: MutableState<String>) {
        TextField(
            value = searchQuery.value,
            onValueChange = { searchQuery.value = it },
            placeholder = { Text(text = "Search...", fontSize = 16.sp) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon"
                )
            },
            trailingIcon = {
                if (searchQuery.value.isNotEmpty()) {
                    IconButton(onClick = { searchQuery.value = "" }) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "Clear Search"
                        )
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .background(Color.Unspecified, shape = RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Unspecified,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }

    @Composable
    fun ListSetting(
        scrollState: ScrollState,
        settings: MutableState<List<SettingType>>,
        searchQuery: MutableState<String>
    ) {
        val filteredData = settings.value.filter { d ->
            d.title.lowercase().trim().contains(searchQuery.value.lowercase()) ||
                    d.shortDescription.lowercase().trim().contains((searchQuery.value.lowercase().trim()))
        }
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            for (data in filteredData) {
                SettingsItemComponent(
                    setting = data,
                    onClick = { id ->
                        when(id){
                            1 -> rootNavigator?.push(BoardSettingsScreen())
                            2 -> rootNavigator?.push(AboutAppScreen())
                            3 -> rootNavigator?.push(AppPermissionScreen())
                            else -> rootNavigator?.push(DonateScreen())
                        }
                    }
                )
            }
        }
    }
}


