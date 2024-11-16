package com.ydhnwb.learnvoyager


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.ydhnwb.learnvoyager.page.primary.PrimaryScreen
import com.ydhnwb.learnvoyager.ui.theme.LearnVoyagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            LearnVoyagerTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigator(PrimaryScreen()){ rootNav ->
                        SlideTransition(navigator = rootNav)
                    }
                }
            }
        }
    }
}


