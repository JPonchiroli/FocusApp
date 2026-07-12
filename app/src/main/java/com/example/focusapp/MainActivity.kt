package com.example.focusapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.focusapp.ui.HomeScreen
import com.example.focusapp.ui.theme.FocusAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FocusAppTheme {
                HomeScreen()
            }
        }
    }
}