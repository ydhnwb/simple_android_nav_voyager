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

class Screen2(val sampleEntity: SampleEntity): Screen {
    @Composable
    override fun Content() {
        val nav = LocalNavigator.current
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Hello ${sampleEntity.name}, You are on the second screen")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                nav?.push(Screen3())
            }) {
                Text(text = "Go to third screen")
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                nav?.pop()
            }) {
                Text(text = "Go back to first screen")
            }
        }
    }
}