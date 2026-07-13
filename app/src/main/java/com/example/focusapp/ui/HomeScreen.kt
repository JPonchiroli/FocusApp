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
import androidx.compose.ui.platform.LocalContext
import com.example.focusapp.model.PermissionState
import com.example.focusapp.model.PermissionType
import com.example.focusapp.permission.PermissionManager
import com.example.focusapp.ui.components.permissions.PermissionsCard

@Composable
fun HomeScreen() {

    val context = LocalContext.current

    val permissionManager = remember {
        PermissionManager(context)
    }

    val permissions by remember {
        mutableStateOf(permissionManager.getPermissionStates())
    }

    val scrollState = rememberScrollState()

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

                when(permission.type){

                    PermissionType.USAGE_ACCESS ->
                        permissionManager.openUsageAccessSettings()

                    PermissionType.ACCESSIBILITY ->
                        permissionManager.openAccessibilitySettings()

                    PermissionType.BATTERY_OPTIMIZATION -> {
                        // Sprint 3
                    }

                }

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