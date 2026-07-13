package com.example.focusapp.permission

import android.app.AppOpsManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.provider.Settings
import com.example.focusapp.model.PermissionState
import com.example.focusapp.model.PermissionType
import com.example.focusapp.service.FocusAccessibilityService

class PermissionManager(
    private val context: Context
) {

    fun hasUsageAccess(): Boolean {

        val appOps = context.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager

        val mode = appOps.checkOpNoThrow(
            AppOpsManager.OPSTR_GET_USAGE_STATS,
            android.os.Process.myUid(),
            context.packageName
        )

        return mode == AppOpsManager.MODE_ALLOWED

    }

    fun openUsageAccessSettings() {

        val intent = Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS)

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        context.startActivity(intent)

    }

    fun openAccessibilitySettings() {

        val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        context.startActivity(intent)

    }

    fun hasAccessibilityPermission(): Boolean {

        val expectedComponent = ComponentName(
            context,
            FocusAccessibilityService::class.java
        )

        val enabledServices = Settings.Secure.getString(
            context.contentResolver,
            Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES
        ) ?: return false

        return enabledServices.contains(expectedComponent.flattenToString())

    }

    fun getPermissionStates(): List<PermissionState> {

        return listOf(

            PermissionState(
                PermissionType.USAGE_ACCESS,
                "Uso de aplicativos",
                "Permite identificar qual aplicativo está aberto.",
                hasUsageAccess()
            ),

            PermissionState(
                PermissionType.ACCESSIBILITY,
                "Acessibilidade",
                "Permite bloquear aplicativos.",
                hasAccessibilityPermission()
            ),

            PermissionState(
                PermissionType.BATTERY_OPTIMIZATION,
                "Otimização de bateria",
                "Evita que o Android interrompa o monitoramento.",
                isIgnoringBatteryOptimizations()
            )

        )

    }

    fun isIgnoringBatteryOptimizations(): Boolean {
        return true
    }

}