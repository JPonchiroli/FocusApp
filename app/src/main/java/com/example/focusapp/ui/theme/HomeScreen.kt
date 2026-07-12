package com.example.focusapp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.*

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

    var isChecked by remember { mutableStateOf(false) }

    Card {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "Monitored applications",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { isChecked = it },
                    enabled = true
                )

                Text("TikTok")

            }

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

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Button(
            onClick = {

            }
        ) {

            Text("Start monitoring")

        }
    }

}