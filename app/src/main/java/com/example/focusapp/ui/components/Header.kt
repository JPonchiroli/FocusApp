package com.example.focusapp.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Header() {

    Text(
        text = "FocusApp",
        style = MaterialTheme.typography.headlineLarge
    )

}