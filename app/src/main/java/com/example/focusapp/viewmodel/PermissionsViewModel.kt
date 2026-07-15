package com.example.focusapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.focusapp.model.PermissionState
import com.example.focusapp.permission.PermissionManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PermissionsViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val permissionManager =
        PermissionManager(application)

    private val _permissions =
        MutableStateFlow<List<PermissionState>>(emptyList())

    val permissions = _permissions.asStateFlow()

    init {
        refreshPermissions()
    }

    fun refreshPermissions() {
        _permissions.value = permissionManager.getPermissionStates()
    }

    fun openPermission(permission: PermissionState) {

        permissionManager.requestPermission(permission.type)

    }

    fun onScreenResumed() {

        refreshPermissions()

    }

}