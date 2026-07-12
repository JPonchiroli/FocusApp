package com.example.focusapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.focusapp.ui.components.Header
import com.example.focusapp.ui.components.MonitoredAppsCard
import com.example.focusapp.ui.components.StartMonitoringButton
import com.example.focusapp.ui.components.StatusCard

@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        verticalArrangement = Arrangement.Top
    ) {

        Header()

        Spacer(modifier = Modifier.height(32.dp))

        MonitoredAppsCard()

        Spacer(modifier = Modifier.height(24.dp))

        StatusCard()

        Spacer(modifier = Modifier.height(32.dp))

        StartMonitoringButton()
    }

}