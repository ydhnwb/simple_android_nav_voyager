package com.ydhnwb.learnvoyager

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class Screen1 : Screen{
    @Composable
    override fun Content() {
        val nav = LocalNavigator.current
        Column(
            modifier =  Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "You are on the first screen")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                val sampleEntity = SampleEntity(1, "Prieyuda Akadita S", null)
                nav?.push(Screen2(sampleEntity))
            }) {
                Text(text = "Go to second screen")
            }

        }
    }
}