package com.example.focusapp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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

@Composable
fun Header() {

    Text(
        text = "FocusApp",
        style = MaterialTheme.typography.headlineLarge
    )

}

@Composable
fun MonitoredAppsCard() {

    Card {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "Monitored applications",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            Checkbox(
                checked = true,
                onCheckedChange = {}
            )

            Text("TikTok")

        }

    }

}

@Composable
fun StatusCard() {

    Card {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "Status",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("Monitoring stopped")

        }

    }

}

@Composable
fun StartMonitoringButton() {

    Button(
        onClick = {

        }
    ) {

        Text("Start monitoring")

    }

}