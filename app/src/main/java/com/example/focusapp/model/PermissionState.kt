package com.example.focusapp.model

data class PermissionState (

    val type: PermissionType,

    val title: String,

    val description: String,

    val granted: Boolean

)