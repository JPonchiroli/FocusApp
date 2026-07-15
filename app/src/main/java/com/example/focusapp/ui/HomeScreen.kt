package com.example.focusapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.focusapp.ui.components.Header
import com.example.focusapp.ui.components.MonitoredAppsCard
import com.example.focusapp.ui.components.StartMonitoringButton
import com.example.focusapp.ui.components.StatusCard
import com.example.focusapp.ui.components.permissions.PermissionsCard
import com.example.focusapp.viewmodel.PermissionsViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeScreen() {

    val viewModel = viewModel<PermissionsViewModel>()

    val permissions by viewModel.permissions.collectAsStateWithLifecycle()

    val lifecycleOwner = LocalLifecycleOwner.current

    val scrollState = rememberScrollState()

    DisposableEffect(lifecycleOwner) {

        val observer = LifecycleEventObserver { _, event ->

            if (event == Lifecycle.Event.ON_RESUME) {

                viewModel.onScreenResumed()

            }

        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {

            lifecycleOwner.lifecycle.removeObserver(observer)

        }

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(scrollState)
    ) {

        Header()

        Spacer(modifier = Modifier.height(24.dp))

        PermissionsCard(

            permissions = permissions,

            onGrantClick = { permission ->

                viewModel.openPermission(permission)

            }

        )

        Spacer(modifier = Modifier.height(24.dp))

        MonitoredAppsCard()

        Spacer(modifier = Modifier.height(24.dp))

        StatusCard()

        Spacer(modifier = Modifier.height(24.dp))

        StartMonitoringButton()

    }

}